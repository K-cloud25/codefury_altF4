package com.altfregistry.dao.interfaces;

import com.altfregistry.exceptions.EntityNotFoundException;
import com.altfregistry.model.users.Employee;

import java.util.List;

public interface EmployeeDao {

    public int createUser(int empID, String empName, String email, String phone, int empType, String passwd);
    public void removeUser(int empId);
    public boolean verifyUserCredentials(int empID, int requiredCredential,String empName,String password) throws EntityNotFoundException;

    public Employee getEmployee(int empId) throws EntityNotFoundException;
}
