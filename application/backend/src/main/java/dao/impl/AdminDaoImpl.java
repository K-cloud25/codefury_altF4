package dao.impl;

import dao.interfaces.AdminDao;
import models.users.Admin;
import util.singleton.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao{
    @Override
    public void addUser(int empID, String empName, String email, String phone, int empType, String passwd) {
        try (Connection connection = DatabaseConnector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Users (Name, Email, Phone, Credits, Role) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1,empName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setInt(4, empType);
            preparedStatement.setString(5, passwd);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public boolean verifyAdmin(int empID) {
        //based on the input ret. true or false if the user is admin or not.
        return false;
    }

    @Override
    public List<Admin> getAllAdmins() {

        //returns a list of all the admins..
        return null;
    }

    @Override
    public boolean verifyAdminCredentials(String empName, String password) {
        return false;
    }


}
