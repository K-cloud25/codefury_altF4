package dao.impl;

import exceptions.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoImplTest {

    @Test
    @DisplayName("Employee Dao Test : Valid User")
    public void testCaseA(){

        EmployeeDaoImpl dao = new EmployeeDaoImpl();

        try {
            assertTrue( dao.verifyUserCredentials(1, 1, "Admin", "Pass") );
        } catch (EntityNotFoundException e) {
            fail(" Error Thrown Valid Employee Test Failed ");
        }

    }

    @Test
    @DisplayName("Employee Dao Test : Invalid User")
    public void testCaseB(){

        EmployeeDaoImpl dao = new EmployeeDaoImpl();

        try {
            assertFalse( dao.verifyUserCredentials(1, 3, "Admin", "Pass") );
        } catch (EntityNotFoundException e) {
            fail(" Error Thrown Valid Employee Test Failed ");
        }

    }

    @Test
    @DisplayName("Employee Dao Test : Invalid User")
    public void testCaseC(){

        EmployeeDaoImpl dao = new EmployeeDaoImpl();

        assertThrows(EntityNotFoundException.class, () -> {
            dao.verifyUserCredentials(5, 3, "Admin", "Pass");
        });

    }

}
