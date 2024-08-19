package dao.interfaces;

import models.Users.Employee;

import java.util.List;

public interface EmployeeDao {


    public int getUserType(Employee Obj);
    public int getUserType(int empId);
    public  void createUser(int empID, String empName, String email, String phone, int empType, String passwd);
    public void removeUser(int empId);
    public boolean doesEmpExists(int empId);
    public List<Employee> getAllEmployees();
}
