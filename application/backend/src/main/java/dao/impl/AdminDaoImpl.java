package dao.impl;

import dao.interfaces.AdminDao;
import util.singleton.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public void addRoom(String roomType , int seatingCapacity) {
   //input : roomId(auto increment , type , seatingCapacity)
        try (Connection connection = DatabaseConnector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Room (roomType,seatingCapacity) VALUES (?, ?)")) {

            preparedStatement.setString(1,roomType);
            preparedStatement.setInt(2, seatingCapacity);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public void modifyRoom(int roomId, String roomType, int seatingCapacity) {
        // Input: roomId, roomType, seatingCapacity
        // Functionality: Update room information based on roomId

        try (Connection connection = DatabaseConnector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE Room SET roomType = ?, seatingCapacity = ? WHERE roomId = ?")) {

            // Set the roomType and seatingCapacity parameters in the prepared statement
            preparedStatement.setString(1, roomType);
            preparedStatement.setInt(2, seatingCapacity);
            preparedStatement.setInt(3, roomId);

            // Execute the update statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                // If no rows were affected, the roomId does not exist
                throw new RuntimeException("Room with ID " + roomId + " does not exist.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error occurred while modifying the room", e);
        }
    }


    @Override
    public void importUser() {

       


    }
}
