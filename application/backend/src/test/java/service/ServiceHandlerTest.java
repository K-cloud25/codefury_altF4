package service;

import models.entities.Amenity;
import models.entities.Meeting;
import models.entities.Room;
import models.users.Admin;
import models.users.Employee;
import models.users.Manager;
import models.users.Member;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

//    @Test
//    @DisplayName("Service handler test : validateEmployee" )
//    public void testCaseC(){
//
//        ServiceHandler serviceHandler = new ServiceHandler();
//
//        assertTrue(serviceHandler.validateEmployee( new Admin(1, "Admin", "admin@gmail.com", "9845689754", 1, "admin"), 1 ));
//
//        serviceHandler.closeService();
//    }

    @Test
    @DisplayName("Service handler test : Add Room with Valid ID")
    public void testCaseD(){
        Admin adminUser = new Admin(1, "Admin", "admin@gmail.com", "9845689754", 1, "admin");

        Room rm  = serviceHandler.addRoom(
                adminUser,
                "classroomtraining",
                20
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

        Member memeber = new Member(3, "Memeber", "memeber@gmail.com", "9845689754", 3, "member");

        List<Meeting> listOfMeetings = serviceHandler.getMeetings(memeber);
        assertNotNull(listOfMeetings);
        assertNotEquals(0, listOfMeetings.size());
    }

    @AfterAll
    public static void cleanUp(){
        serviceHandler.closeService();
        serviceHandler = null;
    }

}
