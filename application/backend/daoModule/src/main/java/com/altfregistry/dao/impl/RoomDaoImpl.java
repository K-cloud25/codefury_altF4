package com.altfregistry.dao.impl;

import com.altfregistry.exceptions.EntityNotFoundException;
import com.altfregistry.dao.interfaces.RoomDaoIntf;
import com.altfregistry.model.entities.Room;
import com.altfregistry.singleton.Log;
import com.altfregistry.singleton.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDaoIntf {


    private final static String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    //New room created by Admin with default amenities according to RoomType
    @Override
    public int createRoom(Room room) {
        try{
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement psRoom = null;
            int insertId = -1;
            String insertIntoRoomSql = "INSERT INTO room(RoomType,SeatingCapacity) VALUES (?,?)";
            // Set parameters for the room
            psRoom = conn.prepareStatement(insertIntoRoomSql, PreparedStatement.RETURN_GENERATED_KEYS);
            psRoom.setString(1, room.getRoomType());
            psRoom.setInt(2,room.getSeatingCapacity());

            // Execute the insertion and retrieve the generated roomID
            int rowsAffected = psRoom.executeUpdate();
            if(rowsAffected>0){
                ResultSet rs = psRoom.getGeneratedKeys();
                if(rs.next()){
                     insertId = rs.getInt(1);
                }
                return insertId;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }



    //Return details of room by its id
    @Override
    public Room getRoomDetails(int roomId) {

        Connection conn = DatabaseConnector.getConnection();
        PreparedStatement psRoom = null;

        try{
            String selectRoomSql = "SELECT * FROM room WHERE roomId = ?";
            psRoom =conn.prepareStatement(selectRoomSql);
            psRoom.setInt(1, roomId);
            ResultSet rs = psRoom.executeQuery();

            while (rs.next()) {
                int roomID = rs.getInt("RoomId");
                String roomType = rs.getString("RoomType");
                int seatingCapacity = rs.getInt("SeatingCapacity");
                psRoom.close();
               return new Room(roomID,roomType,seatingCapacity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public Room getRoomWithID(int roomId) throws EntityNotFoundException {
        Connection conn = DatabaseConnector.getConnection();
        PreparedStatement psRoom = null;

        try{
            String selectRoomSql = "SELECT * FROM room WHERE roomId = ?";
            psRoom =conn.prepareStatement(selectRoomSql);
            psRoom.setInt(1, roomId);
            ResultSet rs = psRoom.executeQuery();

            while (rs.next()) {
                int roomID = rs.getInt("RoomId");
                String roomType = rs.getString("RoomType");
                int seatingCapacity = rs.getInt("SeatingCapacity");
                psRoom.close();
                return new Room(roomID,roomType,seatingCapacity);
            }
        } catch (SQLException e) {
            Log.writeToError("Error fetching room by ID :" +  e.getMessage());
        }
        throw new EntityNotFoundException("Room not found");
    }

    //All room available in given time range will be displayed
    @Override
    public List<Room> getRoomsAvailable(LocalDateTime startTime, LocalDateTime endTime) {
        Connection conn = DatabaseConnector.getConnection();
        PreparedStatement psRoom = null;
        ArrayList<Room> roomsAvailable = new ArrayList<>();
        try{
            String sql =
                    """
                    SELECT *\s
                    FROM room AS r
                    WHERE r.roomID NOT IN (\s
                        SELECT m.roomID
                        FROM meeting AS m
                        WHERE
                        ( m.startTime BETWEEN ? AND ?)
                        AND\s
                        ( m.endTime BETWEEN ? AND ?)
                    );
""";
            psRoom=conn.prepareStatement(sql);

            psRoom.setObject(1, startTime);
            psRoom.setObject(2, endTime);
            psRoom.setObject(3, startTime);
            psRoom.setObject(4, endTime);

            ResultSet rs=psRoom.executeQuery();
                while(rs.next()){
                    int roomID = rs.getInt("RoomId");
                    String roomType = rs.getString("RoomType");
                    int seatingCapacity = rs.getInt("SeatingCapacity");
                    roomsAvailable.add(new Room(roomID,roomType,seatingCapacity));
                }

                psRoom.close();
            } catch (SQLException e) {
            Log.writeToError("Error fetching rooms available :" +  e.getMessage());
        }
        return roomsAvailable;
    }
    // NOT REQUIRED
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
            ps.close();
            if ( updatedRows < 0 ){
                return true;
            }
        } catch (SQLException e) {
            Log.writeToError("SQL Error : " + e.getMessage() + " : " + e.getErrorCode() + " : " + e.getSQLState());
        }

        return false;
    }


    @Override
    public boolean isRoomAvailable(int roomId, LocalDateTime startTime, LocalDateTime endTime) {

        Connection conn = DatabaseConnector.getConnection();
        String query = """
                SELECT
                                	IF (
                                		? IN (
                                			SELECT m.roomID
                                            FROM meeting m
                                            WHERE
                                				(? BETWEEN m.startTime AND m.endTime)
                                                AND
                                                (? BETWEEN m.startTime AND m.endTime)
                                                AND
                                                ? != m.startTime
                                                AND\s
                                                ? != m.endTime
                                		)
                                        , 0, 1) AS available;
                """;

        try{

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, roomId);
            ps.setObject(2, startTime);
            ps.setObject(3, endTime);
            ps.setObject(5, startTime);
            ps.setObject(4, endTime);

            ResultSet rs = ps.executeQuery();
            ps.close();
            if( rs.next() ){

                return rs.getBoolean("available");
            }

        } catch (SQLException e) {
            Log.writeToError("SQL Error : " + e.getMessage() + " : " + e.getErrorCode() + " : " + e.getSQLState());
        }

        return false;
    }

    //totalCost will include seating capacity with all amenities per hour
    @Override
    public int getRoomBaseCost(String roomType) {
        return switch (roomType.toLowerCase()){
            case "classroomtraining":
                yield 10;
            case "onlinetraining":
                yield 15;
            case "conferencecall":
                yield 15;
            case "business":
                yield 5;
            default:
                yield 0;
        };

    }
}
