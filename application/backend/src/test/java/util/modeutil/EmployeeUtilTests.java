package util.modeutil;

import models.users.Admin;
import models.users.Manager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.modelutil.EmployeeUtils;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeUtilTests {

    @Test
    @DisplayName("EmployeeUtilsTestCase : isATypeOf")
    void testCaseA(){

        Admin admin = new Admin(1, "empName", "email", "phone", 1, "pwd");
        assertTrue(EmployeeUtils.isATypeOf(admin , 1));

    }

    @Test
    @DisplayName("EmployeeUtilsTestCase : isATypeOf")
    void testCaseB(){
        Manager manager = new Manager(2, "TempEmp", "email","3455", 2, "pwd", 2000);
        assertEquals(EmployeeUtils.isATypeOf(manager), "Manager");
    }

    @Test
    @DisplayName("EmployeeUtilsTestCase : employeeRoleType")
    void testCaseC(){
        assertEquals(EmployeeUtils.employeeRoleType("Member"), 3);
        assertEquals(EmployeeUtils.employeeRoleType("member"), 3);
    }

}
