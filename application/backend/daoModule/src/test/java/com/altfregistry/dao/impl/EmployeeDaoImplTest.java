package com.altfregistry.dao.impl;

import com.altfregistry.exceptions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoImplTest {

    private static EmployeeDaoImpl dao;

    @BeforeAll
    public static void init(){
        // Init The Common resources across all the tests
        dao = new EmployeeDaoImpl();
    }

    @Test
    @DisplayName("Employee Dao Test : Valid User")
    public void testCaseA(){

        try {
            assertTrue( dao.verifyUserCredentials(1, 1, "Admin", "admin") );
        } catch (EntityNotFoundException e) {
            fail(" Error Thrown Valid Employee Test Failed ");
        }

    }

    @Test
    @DisplayName("Employee Dao Test : Invalid User")
    public void testCaseB(){
        try {
            assertFalse( dao.verifyUserCredentials(1, 3, "Admin", "Pass") );
        } catch (EntityNotFoundException e) {
            fail(" Error Thrown Valid Employee Test Failed ");
        }

    }

    @Test
    @DisplayName("Employee Dao Test : Invalid User")
    public void testCaseC(){
        try {
            assertFalse(
                dao.verifyUserCredentials(5, 3, "Admin", "Pass"));
        } catch (EntityNotFoundException e) {
            fail();
        }

    }

    @Test
    @DisplayName("Employee Dao Test; ValidationEmployeee")
    public void testCaseD() throws EntityNotFoundException {
        assertDoesNotThrow( ()->dao.verifyUserCredentials( 1, 1, "Admin" ,"asds"));
        assertTrue( dao.verifyUserCredentials( 1, 1, "Admin" ,"asds") );

    }

    @Test
    @DisplayName("Employee Dao Test : Adding Admin")
    public void testCaseE() {
        int id = dao.createUser(-1, "newAdmin", "Admin2@gmail.com", "9083423458", 1, "asda");

        assertNotEquals(-1, id);

    }

    @Test
    @DisplayName("Employee Dao Test : Adding Manager")
    public void testCaseF() {
        int id = dao.createUser(-1, "newManager", "newManager@gmail.com", "9083423458", 2, "asda");

        assertNotEquals(-1, id);

    }

    @Test
    @DisplayName("Employee Dao Test : Adding Member")
    public void testCaseG() {
        int id = dao.createUser(-1, "newMember", "newMember@gmail.com", "9083423458", 3, "asda");

        assertNotEquals(-1, id);
    }

    @AfterAll
    public static void destroy(){
        // removing pointer from instance for cleanup;
        dao = null;
    }

}
