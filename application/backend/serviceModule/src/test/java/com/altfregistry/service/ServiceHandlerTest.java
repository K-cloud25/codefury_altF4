package com.altfregistry.service;

import com.altfregistry.model.entities.Amenity;
import com.altfregistry.model.entities.Meeting;
import com.altfregistry.model.entities.Room;
import com.altfregistry.model.users.Admin;
import com.altfregistry.model.users.Employee;
import com.altfregistry.model.users.Manager;
import com.altfregistry.model.users.Member;
import com.altfregistry.singleton.DatabaseConnector;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceHandlerTest {

    private static ServiceHandler serviceHandler;

    @BeforeAll
    public static void init(){
        serviceHandler = new ServiceHandler();
    }

    @Test
    @DisplayName("Login IN Functions : ")
    public void testCaseA(){

        Employee testLogEmployee = new Admin(1, "Admin", "admin@gmail.com", "9845689754", 1,"admin");

        Employee returnOfLogin = serviceHandler.loginInUser(testLogEmployee);

        assertInstanceOf(Admin.class, returnOfLogin);
        assertEquals(testLogEmployee.getEmpID(), returnOfLogin.getEmpID());
    }

    @Test
    @DisplayName("Login IN Functions : ")
    public void testCaseB(){

        Employee fakeAdmin = new Admin(3, "FakeAdmin", "admin@gmail.com", "9845689754", 1,"admin");

        Employee returnOfLogin = serviceHandler.loginInUser(fakeAdmin);

        assertNull(returnOfLogin);
    }

    @Test
    @DisplayName("Service handler test : Add Room with Valid ID")
    public void testCaseD(){
        Admin adminUser = new Admin(1, "Admin", "admin@gmail.com", "9845689754", 1, "admin");

        Room rm  = serviceHandler.addRoom(
                adminUser,
                "onlinetraining",
                25
        );

        assertNotNull(rm);
        assertNotEquals(-1, rm.getRoomID());
    }

    @Test
    @DisplayName("Service handler test : add Employee")
    public void testCaseE(){

        Admin admin = new Admin(1, "Admin", "admin@gmail.com", "9845689754", 1, "admin");
        Manager manager = new Manager(-1, "Mahesh", "mahesh@gmail.com", "9897634251", 2, "Iotseea", 2000);

        Employee insertedManger = serviceHandler.addEmployee(admin, manager);

        assertNotNull(insertedManger);
        assertNotEquals(-1, insertedManger.getEmpID());
    }

    @Test
    @DisplayName("ServiceHandler test : updateRoom Details")
    public void testCaseF(){
        Admin admin = new Admin(1, "Admin", "admin@gmail.com", "9845689754", 1, "admin");
        Room updateRoom = new Room(1, "classroomtraining", 40);

        Room updatedRoom = serviceHandler.updateRoom(admin, updateRoom);

        assertNotNull(updatedRoom);
        assertEquals(updatedRoom.getRoomID(), updateRoom.getRoomID());
        assertEquals(updatedRoom.getSeatingCapacity(), updateRoom.getSeatingCapacity());
    }

    @Test
    @DisplayName("Service Handler Test : get meetings")
    public void testCaseG(){

        Member memeber = new Member(3, "Member", "memeber@gmail.com", "9845689754", 3, "member");

        List<Meeting> listOfMeetings = serviceHandler.getMeetings(memeber);
        assertNotNull(listOfMeetings);
        assertNotEquals(0, listOfMeetings.size());
    }

    @Test
    @DisplayName("Service Handler Test : Get Free Rooms")
    public void testCaseH(){

        // Current Date Time
        LocalDateTime startTimeStamp = LocalDateTime.now();
        // Current Date with time set to 3 hours ahead
        LocalDateTime endTimeStamp = LocalDateTime.now().plusHours(3);

        Manager manager = new Manager(2, "Manager", "manager@gmail.com", "9845689754", 2, "Iotseea", 2000);

        List<Room> listOfRooms = serviceHandler.getAvailableRooms(manager, List.of(startTimeStamp, endTimeStamp));

        assertNotNull(listOfRooms);
        assertNotEquals(0, listOfRooms.size());
        System.out.println(listOfRooms);
    }

    @Test
    @DisplayName("Service Handler : BookRoom")
    public void testCaseI(){

        Manager manager = new Manager(2, "Manager", "manager@gmail.com", "9845689754", 2, "Iotseea", 2000);
        Room room = new Room(1, "classroomtraining", 40);
        List<LocalDateTime> timeSlot = List.of(
                LocalDateTime.parse("23-08-2024 12:00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                LocalDateTime.parse("23-08-2024 14:00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
        );
        List<Employee> listOfParticipants = List.of(
                new Member(3, "Memeber", "memeber@gmail.com", "9845689754", 3, "memeber"),
                new Member(7, "newMember", "newMember@gmail.com", "9083423458", 3, "asda")
                );
        List<Amenity> listOfAddedAmenitites = new ArrayList<Amenity>();
        listOfAddedAmenitites.add(new Amenity("TV", 10));

        Meeting bookedMeeting = serviceHandler.bookAMeeting(manager, room, timeSlot, listOfParticipants, listOfAddedAmenitites);

        System.out.println(bookedMeeting);

        assertNull(bookedMeeting);

    }

    @AfterAll
    public static void cleanUp(){
        DatabaseConnector.closeConnection();
        serviceHandler.closeService();
        serviceHandler = null;
    }

}
