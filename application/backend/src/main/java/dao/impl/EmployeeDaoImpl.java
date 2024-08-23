package dao.impl;

import dao.interfaces.EmployeeDao;
import exceptions.EntityNotFoundException;
import models.users.Admin;
import models.users.Employee;
import models.users.Manager;
import models.users.Member;
import util.singleton.DatabaseConnector;
import util.singleton.Log;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public int createUser(int empID, String empName, String email, String phone, int empType, String passwd) {
        int newEmployeeID = -1;
        try (Connection connection = DatabaseConnector.getConnection();

             PreparedStatement preparedStatement =
                     connection.prepareStatement(
                     "INSERT INTO employee (empName, email, phone, empType, passwd) VALUES (?, ?, ?, ?, ?)"
                     , PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1,empName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setInt(4, empType);
            preparedStatement.setString(5, passwd);

            preparedStatement.executeUpdate();

            ResultSet newEmpIDResultSet = preparedStatement.getGeneratedKeys();
            newEmpIDResultSet.next();
            newEmployeeID = newEmpIDResultSet.getInt(1);

            if ( empType == 2 && newEmployeeID != -1){

                PreparedStatement addCredits = connection.prepareStatement("INSERT INTO credit VALUES (?, 2000)");
                addCredits.setInt(1, newEmployeeID);
                addCredits.executeUpdate();

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        return newEmployeeID;
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
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    // Method Checks The required Credentials with the DB and return respective result
    @Override
    public boolean verifyUserCredentials(int empId,int requiredCredential, String empName, String password)
    throws EntityNotFoundException{

        Connection cnx = DatabaseConnector.getConnection();
        String query = "SELECT * FROM employee WHERE empID = ?";

        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(query);
            preparedStatement.setInt(1, empId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if ( resultSet.next() ){

                int employeeType=resultSet.getInt("empType");
                String employeeName=resultSet.getString("empName");

                return employeeType == requiredCredential && empName.equals(employeeName);


            }else{
                throw new EntityNotFoundException("No Such User");
            }

        } catch (SQLException | EntityNotFoundException e) {
            throw new EntityNotFoundException("No Such User");
        }

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
