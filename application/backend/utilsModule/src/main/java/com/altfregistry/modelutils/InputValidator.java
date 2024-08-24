package com.altfregistry.modelutils;

import com.altfregistry.exceptions.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    // Email Regex Checks for proper email format
    private final static String emailValidationRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    // Check username must not have special chars and must have length of 5 or more
    private final static String usernameValidationRegex = "^[a-zA-Z0-9.]{5,}$";
    // Regex to check 10-digit phone number
    private final static String phoneValidationRegex = "^[789]\\d{9}$";

    public static boolean isValidEmailAddress(String email) throws ValidationFailedException {
        if ( !Pattern.matches(emailValidationRegex, email)  )
            throw new ValidationFailedException( "Email Address Not in a Valid Format" );
        return true;
    }

    public static boolean isValidUsername(String userName) throws ValidationFailedException {
        if  ( !Pattern.matches( usernameValidationRegex, userName) )
            throw  new ValidationFailedException("Username not in a valid Format");
        return true;
    }

    public static boolean isValidPhone(String phone) throws ValidationFailedException {
        if  ( !Pattern.matches( phoneValidationRegex, phone) )
            throw  new ValidationFailedException("Username not in a valid Format");
        return true;
    }

    public static boolean isValidPwd(String pwd) throws ValidationFailedException {
        if ( pwd.length() < 6 )
            throw  new ValidationFailedException("Password Length Cannot Be Less than 6 chars");
        return true;
    }

    public static boolean doDatesIntersect(List<LocalDateTime> range1, List<LocalDateTime> range2) throws  IllegalArgumentException{

        if ( range1.size() < 2 && range2.size() < 2)
            throw new IllegalArgumentException("Invalid Range Passed");

        LocalDateTime startT1 = range1.get(0);
        LocalDateTime startT2 = range2.get(0);
        LocalDateTime endT1 = range1.get(1);
        LocalDateTime endT2 = range1.get(1);

        if ( startT1.isBefore(endT2) && startT2.isBefore(endT1) )
            return true;


        return false;

    }

    public static boolean isValidRoomType( String roomType ) throws ValidationFailedException {
        String tempLowerCase = roomType.toLowerCase();
        if ( tempLowerCase.equals("classroomtraining") || tempLowerCase.equals("onlinetraining") || tempLowerCase.equals("conferencecall") || tempLowerCase.equals("business") ){
            return true;
        }

        throw new ValidationFailedException("Invalid Room Type");
    }


}
