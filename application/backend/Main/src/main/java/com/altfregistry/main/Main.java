package com.altfregistry.main;

import com.altfregistry.model.entities.Amenity;
import com.altfregistry.model.entities.Meeting;
import com.altfregistry.model.entities.Room;
import com.altfregistry.model.users.Admin;
import com.altfregistry.model.users.Employee;
import com.altfregistry.model.users.Manager;
import com.altfregistry.model.users.Member;
import com.altfregistry.service.ServiceHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        //Employee Login functionality checks:

        System.out.println("Login Function in Operation : ");
                // Create an instance of the Employee subclass (e.g., Admin)
                Employee employee1 = new Admin(2, "Admin1", "admin1@gmail.com", "7480667734", 1, "Pass");

                // Assume that the service handler is already initialized somewhere
                ServiceHandler serviceHandler = new ServiceHandler();

                // Call the loginInUser method
                Employee loggedInEmployee = serviceHandler.loginInUser(employee1);

                // Check if the login was successful
                if (loggedInEmployee != null) {
                    System.out.println("Login successful for employee: " + loggedInEmployee.getEmpName());
                } else {
                    System.out.println("Login failed.");
                }
        System.out.println("----------------------------------------------------------------------------------");

        //create users with a particular id :

        System.out.println("Adding users of different Roles");
                Employee newEmployeeManager = new Manager(-1, "manager1", "manager1@gmail.com", "7480667734", 2, "manPass", 120);
                Employee newEmployeeMember = new Member(-1, "member1", "member1@gmail.com", "9455075359", 3, "MemPass");
                //add Users :

                Employee addedEmployeeManager = serviceHandler.addEmployee(employee1, newEmployeeManager);
                Employee addedEmployeeMember = serviceHandler.addEmployee(employee1, newEmployeeMember);

                if (addedEmployeeManager != null)
                    System.out.println("New Employee -Manager added successfully " + addedEmployeeManager.toString());
                else
                    System.out.println("Error while adding Employee ... ");

                if (addedEmployeeMember != null)
                    System.out.println("New Employee -Member added successfully " + addedEmployeeMember.toString());
                else
                    System.out.println("Error while adding Employee ... ");
        System.out.println("----------------------------------------------------------------------------------");

        //Add Room to the Meeting :

        System.out.println("Adding Rooms with details : ");
                Room addedRoom = serviceHandler.addRoom(employee1, "classroomtraining", 50);
                if (addedRoom != null) {
                    System.out.println("Room added Succesfully : " + addedRoom.toString());
                } else {
                    System.out.println("error in adding Room");
                }
        System.out.println("----------------------------------------------------------------------------------");
        //Update Room Details :

        System.out.println("Updating Room Details : ");
                Room updatedRoom = serviceHandler.updateRoom(employee1, new Room(addedRoom.getRoomID(), "classroomtraining", 100));
                if (updatedRoom != null) {
                    System.out.println("The Room with id " + addedRoom.getRoomID() + " is updated successfully : " + updatedRoom.toString());

                } else {
                    System.out.println("error in updating Room : ");
                }
        System.out.println("----------------------------------------------------------------------------------");

        //checking for available rooms in a time slot :

        System.out.println("Avalibilty check for a time slot : ");
                LocalDateTime startTimeStamp = LocalDateTime.now();
                // Current Date with time set to 3 hours ahead
                LocalDateTime endTimeStamp = LocalDateTime.now().plusHours(3);


                List<Room> listOfRooms = serviceHandler.getAvailableRooms(addedEmployeeManager, List.of(startTimeStamp, endTimeStamp));
                if (!listOfRooms.isEmpty()) {
                    System.out.println("List of available rooms free in the  time slot : " +startTimeStamp+" to "+endTimeStamp);
                    for (Room r : listOfRooms) {
                        System.out.println(r.toString());
                    }
                } else {
                    System.out.println("No empty room found for the time slot ");
                }
        System.out.println("----------------------------------------------------------------------------------");
        //Booking a particular Room function by a manager :

        System.out.println("Booking a particular Room for a Meeting ");
                List<LocalDateTime> timeSlot = List.of(
                        LocalDateTime.parse("10-08-2024 12:00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                        LocalDateTime.parse("10-08-2024 14:00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                );
                List<Employee> listOfParticipants = List.of(
                        new Member(3, "Memeber", "memeber@gmail.com", "9845689754", 3, "memeber"),
                        new Member(7, "newMember", "newMember@gmail.com", "9083423458", 3, "asda")
                );
                List<Amenity> listOfAddedAmenitites = new ArrayList<Amenity>();
                listOfAddedAmenitites.add(new Amenity("TV", 10));

                Meeting bookedMeeting = serviceHandler.bookAMeeting(addedEmployeeManager, addedRoom, timeSlot, listOfParticipants, listOfAddedAmenitites);

                if (bookedMeeting != null)
                    System.out.println(bookedMeeting);
                else
                    System.out.println("Sorry the meeting room can't be booked ");

        System.out.println("----------------------------------------------------------------------------------");
        //List of meeting for a particular member in which he/she is enrolled :
        System.out.println("Fetching the meeting details for a particular member :");
                List<Meeting> listOfMeetings = serviceHandler.getMeetings(addedEmployeeMember);
                if (!listOfMeetings.isEmpty()) {
                    System.out.println("The list of meeting for the manager : " + addedEmployeeManager.getEmpID() + "is : ");
                    for (Meeting m : listOfMeetings) {
                        System.out.println(m.toString());
                    }
                } else {
                    System.out.println("No meetings were found for the member with id :" + addedEmployeeMember.getEmpID());
                }

    }
}
