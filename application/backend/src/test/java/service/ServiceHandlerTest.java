package service;

import models.users.Admin;
import models.users.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceHandlerTest {

    @Test
    @DisplayName("Login IN Functions : ")
    public void testCaseA(){

        ServiceHandler serviceHandler = new ServiceHandler();

        Employee testLogEmployee = new Admin(1, "Admin", "admin@gmail.com", "9845689754", 1,"admin");

        Employee returnOfLogin = serviceHandler.loginInUser(testLogEmployee);

        assertInstanceOf(Admin.class, returnOfLogin);
        assertEquals(testLogEmployee.getEmpID(), returnOfLogin.getEmpID());

        serviceHandler.closeService();

    }

    @Test
    @DisplayName("Login IN Functions : ")
    public void testCaseB(){

        ServiceHandler serviceHandler = new ServiceHandler();

        Employee fakeAdmin = new Admin(3, "FakeAdmin", "admin@gmail.com", "9845689754", 1,"admin");

        Employee returnOfLogin = serviceHandler.loginInUser(fakeAdmin);

        assertNull(returnOfLogin);

        serviceHandler.closeService();
    }

}
