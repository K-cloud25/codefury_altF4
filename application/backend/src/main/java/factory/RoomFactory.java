package factory;

import dao.interfaces.RoomDaoIntf;
import exceptions.EntityNotFoundException;
import models.entities.Room;
import util.singleton.DatabaseConnector;
import util.singleton.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoomFactory {
    public static RoomDaoIntf getRoomDao() {
        return new RoomDaoIntf() {

            @Override
            public int createRoom(Room room) {

                Connection cnx = DatabaseConnector.getConnection();

                PreparedStatement ps = null;
                String query = "INSERT INTO room (roomType, seatingCapacity) VALUE (?,?)";
                int insertedID = -1;
                try{
                    ps = cnx.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

                    ps.setString(1, room.getRoomType());
                    ps.setInt(2, room.getSeatingCapacity());

                    int updatedRows = ps.executeUpdate();

                    if ( updatedRows < 0 ){
                        Log.writeToError("No row Entered error in SQL query");
                        throw new SQLException("Row Not Inserted");
                    }

                    ResultSet newKeyResultSet = ps.getGeneratedKeys();
                    newKeyResultSet.next();

                    insertedID = newKeyResultSet.getInt(1);
                } catch (SQLException e) {
                    Log.writeToError("SQL Error : " + e.getMessage() + " : " + e.getErrorCode() + " : " + e.getSQLState());
                    return -1;
                }
                return insertedID;
            }

            @Override
            public Room getRoomDetails(int roomId) {
                return null;
            }

            @Override
            public void deleteRoom(int roomId) {

            }

            @Override
            public boolean updateRoom(Room room, int roomId) {

                Connection cnx = DatabaseConnector.getConnection();
                PreparedStatement ps = null;
                String query = "UPDATE room SET seatingCapacity = ? WHERE roomId = ?";

                try {
                    ps = cnx.prepareStatement(query);
                    ps.setInt(1, room.getSeatingCapacity());
                    ps.setInt(2, roomId);

                    int updatedRows = ps.executeUpdate();
                    if ( updatedRows < 0 ){
                        return true;
                    }
                } catch (SQLException e) {
                    Log.writeToError("SQL Error : " + e.getMessage() + " : " + e.getErrorCode() + " : " + e.getSQLState());
                }

                return false;
            }

            @Override
            public Room getRoomWithID(int roomId) throws EntityNotFoundException {

                Connection cnx = DatabaseConnector.getConnection();

                PreparedStatement ps = null;
                String query = "SELECT * FROM room WHERE roomId = ?";
                Room room = null;

                try{
                    ps = cnx.prepareStatement(query);
                    ps.setInt(1, roomId);
                    ResultSet resultSet = ps.executeQuery();

                    resultSet.next();
                    if ( resultSet.getFetchSize() < 0)
                        throw new EntityNotFoundException();
                    room = new Room(resultSet.getInt("roomId"), resultSet.getString("roomType"), resultSet.getInt("seatingCapacity"));

                } catch (SQLException e) {
                    Log.writeToError("SQL Error : " + e.getMessage() + " : " + e.getErrorCode() + " : " + e.getSQLState());
                    throw new EntityNotFoundException(e);
                }

                return room;

            }

            @Override
            public List<Room> getRoomsAvailable(LocalDateTime startTime, LocalDateTime endTime) {

                return List.of();
            }

            @Override
            public boolean isRoomAvailable(int roomId, LocalDateTime startTime, LocalDateTime endTime) {
                return false;
            }

            @Override
            public int getRoomBaseCost(int roomId) {
                return 0;
            }
        };
    }
}
