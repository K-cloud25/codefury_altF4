package service;

import exceptions.InvalidCredentialsException;
import exceptions.ValidationFailedException;
import models.users.Employee;
import util.modelutil.EmployeeUtils;
import util.singleton.Log;

public class ServiceHandler {

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

    public Employee loginInUser( Employee frontEndEmp ) {

        // Verify Employee Sent From User
        // Compare Employee Validation

        // Get employee Object From DB
        Employee backendEmp = null;

        if (! employeeValidation( frontEndEmp, backendEmp ) ){
            return null;
        }

        // GetBackend Employee
        Log.writeToLog("User " + backendEmp + " Logged In System");
        return backendEmp;
    }



}
