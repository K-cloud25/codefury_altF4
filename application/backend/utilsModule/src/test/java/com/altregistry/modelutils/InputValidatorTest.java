package com.altregistry.modelutils;

import com.altfregistry.exceptions.ValidationFailedException;
import com.altfregistry.modelutils.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    @Test
    @DisplayName("InputValidation : isValidEmailAddress")
    public void testCaseA(){
        try {
            assertTrue( InputValidator.isValidEmailAddress("abc.25@gmail.com") );
        } catch (ValidationFailedException e) {
            fail();
        }
    }

    @Test
    @DisplayName("InputValidation : isValidEmailAddress")
    public void testCaseB() {
        assertThrows(ValidationFailedException.class,() ->  InputValidator.isValidEmailAddress("abc.srt@f"));
    }

    @Test
    @DisplayName(" Test : isValidUsername")
    public void testCaseC(){
        try {
            assertTrue(InputValidator.isValidUsername("KeyurOak"));
        } catch (ValidationFailedException e) {
            fail();
        }
    }

    @Test
    @DisplayName("Test : isValidUsername")
    public void testCaseD() {
        assertThrows(ValidationFailedException.class,() ->  InputValidator.isValidUsername("abc.sr,"));
    }

    @Test
    @DisplayName("Test : isValidPhone")
    public void testCaseE(){
        try {
            assertTrue(InputValidator.isValidPhone("9912345244"));
        } catch (ValidationFailedException e) {
            fail();
        }
    }

    @Test
    @DisplayName("Test : isValidPhone")
    public void testCaseF() {
        assertThrows(ValidationFailedException.class,() ->  InputValidator.isValidPhone("34551"));
    }

    @Test
    @DisplayName("Test : isValidPwd")
    public void testCaseG(){
        assertThrows(ValidationFailedException.class,() ->  InputValidator.isValidPwd("root"));
    }

    @Test
    @DisplayName("Test : doDatesIntersect")
    public void testCaseH(){

        LocalDateTime start1  = LocalDateTime.of(2024,8,1,9,0);
        LocalDateTime end1  = LocalDateTime.of(2024,8,1,11,0);
        LocalDateTime start2  = LocalDateTime.of(2024,8,1,10,0);
        LocalDateTime end2  = LocalDateTime.of(2024,8,1,12,0);

        assertTrue( InputValidator.doDatesIntersect(Arrays.asList(start1, end1), Arrays.asList(start2, end2) ));
    }

    @Test
    @DisplayName("Test : doDatesIntersect")
    public void testCaseI(){

        LocalDateTime start1  = LocalDateTime.of(2024,8,1,9,0);
        LocalDateTime end1  = LocalDateTime.of(2024,8,1,10,0);
        LocalDateTime start2  = LocalDateTime.of(2024,8,1,11,0);
        LocalDateTime end2  = LocalDateTime.of(2024,8,1,11,30);

        assertFalse( InputValidator.doDatesIntersect(Arrays.asList(start1, end1), Arrays.asList(start2, end2) ));
    }

}
