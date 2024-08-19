package dao.interfaces;

import models.users.Admin;

import java.util.List;

public interface AdminDao{

    public void addUser(int empID, String empName, String email, String phone, int empType, String passwd);
    public boolean verifyAdmin(int empID);
    public List<Admin> getAllAdmins();
    public boolean verifyAdminCredentials(String empName,String password);
}
