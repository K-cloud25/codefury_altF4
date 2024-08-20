package dao.impl;

import dao.interfaces.EmployeeDao;
import exceptions.EntityNotFoundException;
import models.users.Admin;
import models.users.Employee;
import models.users.Manager;
import models.users.Member;
import util.singleton.DatabaseConnector;
import util.singleton.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public int verifyUserType(Employee Obj) {

        if(Obj instanceof Admin)
            return 1;
        else if(Obj instanceof Manager)
            return 2;
        else if(Obj instanceof Member)
            return 3;
        else
            return -1;
    }

    @Override
    public int getUserType(int empId) {
        try (Connection connection =DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM employee WHERE UserID = ?")) {

            preparedStatement.setInt(1, empId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                   int type=resultSet.getInt("empType");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching user by ID", e);
        }

        throw new IllegalArgumentException("User not found");
    }

    @Override
    public void createUser(int empID, String empName, String email, String phone, int empType, String passwd) {
        try (Connection connection = DatabaseConnector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO employee (Name, Email, Phone, Credits, Role) VALUES (?, ?, ?, ?, ?)")) {

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
    public void removeUser(int empId) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM employee WHERE UserID = ?")) {

            preparedStatement.setInt(1, empId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new EntityNotFoundException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting user", e);
        } catch (EntityNotFoundException e) {
            System.out.println("Error in deletion ");
        }

    }

    @Override
    public boolean doesEmpExists(int empId) {
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public boolean verifyUserCredentials(String empName, String password) {
        return false;
    }

    @Override
    public Employee getEmployee(int empId) throws EntityNotFoundException{

        try (Connection connection =DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM employee WHERE empID = ?")) {

            preparedStatement.setInt(1, empId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    int empID=resultSet.getInt("empId");
                    String empName = resultSet.getString("empName");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    int empType = resultSet.getInt("empType");
                    String passwd = resultSet.getString("passwd");

                    switch (empType){
                        case 1:
                            return new Admin(empID, empName, email, phone, 1, passwd);

                        case 2:

                                PreparedStatement ps = connection.prepareStatement(
                                        "SELECT creditVal FROM credit WHERE empID = ?"
                                );
                                ps.setInt(1, empID);
                                ResultSet creditScoreSet = ps.executeQuery();

                                return new Manager(empID, empName, email, phone, 2, passwd, creditScoreSet.getInt(1));
                        case 3:
                            return new Member(empID, empName, email, phone, 3, passwd);
                        default:
                            throw new IllegalArgumentException("Type of Employee Unkown");
                    }

                }
            }
        } catch (SQLException e) {
            Log.writeToError("Error fetching user by ID :" +  e.getMessage());
        }

        throw new EntityNotFoundException("User not found");

    }
}
