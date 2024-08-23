package service;

import dao.interfaces.*;
import exceptions.*;
import factory.*;
import models.entities.Amenity;
import models.entities.Meeting;
import models.entities.Room;
import models.users.Employee;
import util.modelutil.EmployeeUtils;
import util.modelutil.InputValidator;
import util.singleton.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

// Service Handler Will Interact with a UI and considers that the UI can operate on Java Based Objects.

public class ServiceHandler {

    private EmployeeDao employeeDao;
    private MeetingDaoIntf meetingDao;
    private RoomDaoIntf roomDao;
    private MemberIntf memberDao;

    Connection cnx = null;

    public ServiceHandler(){

        employeeDao = EmployeeFactory.getEmployeeDao();
        meetingDao = MeetingFactory.getMeetingDao();
        roomDao = RoomFactory.getRoomDao();
        memberDao = MemberFactory.getMemberDao();
    }

    private boolean employeeValidation( Employee frontendSentEmployee, Employee backendEmployee ){

        if ( backendEmployee == null ){
            Log.writeToLog("Login In Failed for Employee : " + frontendSentEmployee + " No Such employee found ");
            return false;
        }

        try{

            EmployeeUtils.isValidEmployee(frontendSentEmployee, backendEmployee);

        } catch (ValidationFailedException e) {
            Log.writeToLog("Login In Failed for Employee : " + frontendSentEmployee + " No Such employee found ");
            return false;
        }

        return true;
    }

    // Function Check If User Is of Type Admin
    private boolean validateEmployee(Employee user, int requiredCredentials){
        // Verify If Employee is of type Admin
        try {
            if ( !employeeDao.verifyUserCredentials( user.getEmpID(), requiredCredentials, user.getEmpName(), user.getPasswd()) ){
                Log.writeToError("Access Denied: User does not have privilege of adding a room");
                Log.writeToLog("User : " + user+ " tried to access unauthorized method Add Room" );
                return false;
            }
        } catch (EntityNotFoundException e) {
            return false;
        }

        return true;
    }

    // Indirect Functionality -> Returns Database Verified Entity as Positive response
    public Employee loginInUser( Employee frontEndEmp ) {

        // Verify Employee Sent From User
        // Compare Employee Validation

        // Get employee Object From DB
        Employee backendEmp = null;
        try {
            backendEmp = employeeDao.getEmployee(frontEndEmp.getEmpID());
        } catch (EntityNotFoundException e) {
            Log.writeToError("Unable to find employee : " + frontEndEmp.getEmpID());
            return null;
        }

        if (! employeeValidation( frontEndEmp, backendEmp ) ){
            return null;
        }

        // GetBackend Employee
        Log.writeToLog("User " + backendEmp + " Logged In System");
        return backendEmp;
    }

    // Admin Functions

    // Admin : Add Room
    public Room addRoom(Employee registeringEmp, String roomType, int seatingCapacity){

        if ( !validateEmployee(registeringEmp, 1) ){
            Log.writeToLog("Unauthorized User Trying to add Resource");
            return null;
        }

        try {
            InputValidator.isValidRoomType(roomType);
            if ( seatingCapacity < 0 ){
                throw  new ValidationFailedException("No of Seats in a room Cannot be Zero");
            }
        }
        catch (ValidationFailedException e){
            Log.writeToLog(e.getMessage());
            return null;
        }

        //Creating A Dummy Object For Insertion.
        Room dummyRoom = new Room(-1, roomType, seatingCapacity);

        // Dao Impl for Adding Room Information to be added to DB
        int roomID = roomDao.createRoom(dummyRoom);
        // Updating with new Room ID
        dummyRoom.setRoomID(roomID);
        Log.writeToLog("Room " + dummyRoom + " created by " + registeringEmp );

        // Returning Room Instance as a positive response
        return dummyRoom;
    }

    // Admin : Add User
    public Employee addEmployee(Employee registeringEmp, Employee newEmployeeObj){

        // Admin Level Validation
        if ( !validateEmployee(registeringEmp, 1)){
            return null;
        }

        // Employee Information Validation
        try{

            InputValidator.isValidUsername(newEmployeeObj.getEmpName());
            InputValidator.isValidPhone(newEmployeeObj.getPhone());
            InputValidator.isValidEmailAddress(newEmployeeObj.getEmail());
            InputValidator.isValidPwd(newEmployeeObj.getPasswd());

        }catch (ValidationFailedException e){
            Log.writeToError("Validation Failed For " + newEmployeeObj + " Validation Error : " + e.getMessage() );
            return null;
        }

        int employeeID = employeeDao.createUser(-1, newEmployeeObj.getEmpName(), newEmployeeObj.getEmail(), newEmployeeObj.getPhone(), newEmployeeObj.getEmpType(), newEmployeeObj.getPasswd());

        newEmployeeObj.setEmpID(employeeID);

        Log.writeToLog("Employe : " + newEmployeeObj + " Successfully Created By : " + registeringEmp);
        return newEmployeeObj;
    }

    // Admin : Update user
    public Room updateRoom(Employee registeringEmp, Room room){

        if ( !validateEmployee(registeringEmp, 1) ){
            return null;
        }

        Room backendUpdateRoom = null;

        try{
            InputValidator.isValidRoomType(room.getRoomType());

            if ( room.getSeatingCapacity() <= 0 ){
                throw  new ValidationFailedException("Seating Capacity Cannot Be Negative or Zero");
            }

            // Checks if Room Actually Exists for Update
            backendUpdateRoom = roomDao.getRoomWithID(room.getRoomID());

        }catch (ValidationFailedException e){
            Log.writeToError("Validation Failed For " + room + " Validation Error : " + e.getMessage() );
        } catch (EntityNotFoundException e) {
            Log.writeToError("No Such Room Found: Id " + room.getRoomID() );
            return null;
        }

        if (roomDao.updateRoom(room, backendUpdateRoom.getRoomID())){
            Log.writeToLog("Room " + room + " updated by " + registeringEmp );
        }else{
            Log.writeToError("Room not updated Update Failed for Room : " + room);
        }

        return room;

    }

    // Manager : Get Available Rooms
    public List<Room> getAvailableRooms(Employee requestingEmployee, List<LocalDateTime> rangeOfTime){

        // Verify If Employee is of Type Member
        if (!validateEmployee(requestingEmployee, 2) ){
            return null;
        }

        List<Room> freeRooms = roomDao.getRoomsAvailable(rangeOfTime.get(0), rangeOfTime.get(1));
        return freeRooms;
    }

    // Manager : Book Room
    public Meeting bookAMeeting(
            Employee requestEmployee,       // Manager Requesting the Room
            Room room, // Room requested by Mananger
            List<LocalDateTime> timeSlot,   // TimeSlot Requested by Manager
            List<Employee> employees,   // Enployees Added To Meeting
            List<Amenity> addedAmenity // Extra Amenity
    ){

        // Verify If Employee is of Type Member
        if ( validateEmployee(requestEmployee, 2) ){
            return null;
        }

        Room backEndEntityRoom = null;
        try{
            backEndEntityRoom = roomDao.getRoomWithID(room.getRoomID());
        } catch (EntityNotFoundException e) {
            Log.writeToError("No Such Room Found: Id " + room.getRoomID() );
            return null;
        }

        // Validation

        //  Checking if Time slots are provided
        if ( timeSlot.size() < 2){
            Log.writeToLog("Time Slot Missing : Invalid Selection");
            return null;
        }

        //  Get Clashing Meeting
        if (meetingDao.isClashingMeeting(backEndEntityRoom.getRoomID(), timeSlot.get(0), timeSlot.get(1)) ){
            Log.writeToLog("Conflict while Booking, Room already Booked");
            return null;
        }

        // Start of Complex Transaction
        cnx = DatabaseConnector.getConnection();
        try {
            cnx.setAutoCommit(false);
        } catch (SQLException e) {
            Log.writeToError("MySQL error : " + e.getMessage() );
        }

        int baseCost = roomDao.getRoomBaseCost(room.getRoomID());
        int addedCost = addedAmenity.stream().mapToInt(Amenity::getCostPerHour).sum();

        // Setting dummy Meeting
        Meeting newMeeting = new Meeting(-1, room.getRoomID(), requestEmployee.getEmpID(), timeSlot.get(0),timeSlot.get(1), baseCost+addedCost, "Meeting Booked By : " +requestEmployee.getEmpName() );

        // Debit Credits
        // Check Valid Amount
        // Rollback

        // Book Meeting
        int meetingID =  meetingDao.bookMeeting(newMeeting, requestEmployee.getEmpID(), addedAmenity);
        newMeeting.setMeetingID(meetingID);

        List<Integer> listOfEmpID = employees.stream().mapToInt(Employee::getEmpID).boxed().toList();

        meetingDao.addUsersToMeeting(meetingID, listOfEmpID);


        try {
            cnx.commit();
            cnx.setAutoCommit(true);
        } catch (SQLException e) {
            Log.writeToError("MySQL error : " + e.getMessage() );
        }

        return null;
    }

    // Member : GetMyRooms
    public List<Meeting> getMeetings( Employee member ){

        // Validate user
        if (!validateEmployee(member, 3)){
            Log.writeToLog("Unauthorized User trying to access restricted resource");
            return null;
        }

        try {
            return memberDao.getMeeting(member.getEmpID());

        } catch (EntityNotFoundException e) {
            Log.writeToError("No Such Employee Found: Id " + member.getEmpID() );
        } catch (InvalidCredentialsException e) {
            Log.writeToError("Invalid Credentials for user " + member);
        }


        return null;

    }

    public void closeService(){
        employeeDao = null;
        meetingDao = null;
        roomDao = null;
        memberDao = null;
        cnx = null;
        DatabaseConnector.closeConnection();
    }
}
