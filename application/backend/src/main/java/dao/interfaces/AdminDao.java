package dao.interfaces;

import models.users.Admin;

import java.util.List;

public interface AdminDao{

    // TODO: Remove Add User For Admin As Only Employee Interface will handle Insertion for Employees
    public int addUser(int empID, String empName, String email, String phone, int empType, String passwd);
    public boolean verifyAdmin(int empID);
    public List<Admin> getAllAdmins();
    public boolean verifyAdminCredentials(String empName,String password);
}
