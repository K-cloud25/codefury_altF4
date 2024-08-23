package dao.interfaces;

import exceptions.EntityNotFoundException;
import models.users.Employee;

import java.util.List;

public interface EmployeeDao {

    public int createUser(int empID, String empName, String email, String phone, int empType, String passwd);
    public void removeUser(int empId);
    public List<Employee> getAllEmployees();
    public boolean verifyUserCredentials(int empID, int requiredCredential,String empName,String password) throws EntityNotFoundException;

    public Employee getEmployee(int empId) throws EntityNotFoundException;
}
