package dao.impl;

import dao.interfaces.RoomDaoIntf;
import exceptions.EntityNotFoundException;
import models.entities.Amenity;
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

public class RoomDaoImpl implements RoomDaoIntf {

    Connection conn = DatabaseConnector.getConnection();
    PreparedStatement psRoom = null;
    ResultSet rs = null;
    int insertId=-1;
    int roomID;
    String roomType;
    int seatingCapacity;
    List<Amenity> amenities =null;
    String amenityName;
    int costPerHour;



    //New room created by Admin with default amenities according to RoomType
    @Override
    public int createRoom(Room room) {
        try{

            String insertIntoRoomSql = "INSERT INTO room(RoomType,SeatingCapacity) VALUES (?,?)";
            // Set parameters for the room
            psRoom = conn.prepareStatement(insertIntoRoomSql);
            psRoom.setString(1, room.getRoomType());
            psRoom.setInt(2,room.getSeatingCapacity());

            // Execute the insertion and retrieve the generated roomID
            int rowsAffected = psRoom.executeUpdate();
            if(rowsAffected>0){
                ResultSet rs = psRoom.getGeneratedKeys();
                if(rs.next()){
                     insertId = rs.getInt(1);
                }

//                // If the room was successfully inserted, proceed with inserting the amenities
//                if(insertId!= -1){
//                    String insertAmenitiesIntoRoomSql = "INSERT INTO amenity (AmenityName, CostPerHour) VALUES (?,?)";
//                    PreparedStatement psAmenity = conn.prepareStatement(insertAmenitiesIntoRoomSql);
//                    for(Amenity amenity : room.getAmenities()){
//                        psAmenity.setString(1,amenity.getName());
//                        psAmenity.setInt(2,amenity.getCostPerHour());
//                        psAmenity.executeUpdate();
//                    }
//                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }



    //Return details of room by its id
    @Override
    public Room getRoomDetails(int roomId) {
        try{
            Room room=null;
            String selectRoomSql = "SELECT * FROM room WHERE roomId = ?";
            psRoom =conn.prepareStatement(selectRoomSql);
            psRoom.setInt(1, roomId);
            rs = psRoom.executeQuery();

            while (rs.next()) {
                roomID = rs.getInt("RoomId");
                roomType = rs.getString("RoomType");
                seatingCapacity = rs.getInt("SeatingCapacity");
                for (Amenity amenity : amenities){
                    amenityName = rs.getString("AmenityName");
                    costPerHour = rs.getInt("CostPerHour");
                    amenities.add(new Amenity(amenityName,costPerHour));
                }
               return new Room(roomID,roomType,seatingCapacity,amenities);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public Room getRoomWithID(int roomId) throws EntityNotFoundException {
        try{
            Room room=null;
            String selectRoomSql = "SELECT * FROM room WHERE roomId = ?";
            psRoom =conn.prepareStatement(selectRoomSql);
            psRoom.setInt(1, roomId);
            rs = psRoom.executeQuery();

            while (rs.next()) {
                roomID = rs.getInt("RoomId");
                roomType = rs.getString("RoomType");
                seatingCapacity = rs.getInt("SeatingCapacity");
//                for (Amenity amenity : amenities){
//                    amenityName = rs.getString("AmenityName");
//                    costPerHour = rs.getInt("CostPerHour");
//                    amenities.add(new Amenity(amenityName,costPerHour));
//                }
                return new Room(roomID,roomType,seatingCapacity,amenities);
            }
        } catch (SQLException e) {
            Log.writeToError("Error fetching room by ID :" +  e.getMessage());
        }
        throw new EntityNotFoundException("Room not found");
    }

    //All room available in given time range will be displayed
    @Override
    public List<Room> getRoomsAvailable(LocalDateTime startTime, LocalDateTime endTime) {
        try{
            List<Room> availableRooms=null;
            String sql = "SELECT * "+
                    "FROM employee e"+
                    "JOIN mapMeetingUser mmu ON e.empID = mmu.empID"+
                    "JOIN meeting m ON mmu.meetingID = m.meetingID"+
                    "WHERE"+
                    "(m.startTime BETWEEN ? AND ?)"+
                    "OR"+
                    "(m.endTime BETWEEN ? AND ?)"+
                    "OR"+
                    "(? BETWEEN m.startTime AND m.endTime"+
                    "OR"+
                    "(? BETWEEN m.startTime AND m.endTime)";

            psRoom=conn.prepareStatement(sql);

            psRoom.setObject(1, startTime);
            psRoom.setObject(2, endTime);
            psRoom.setObject(3, startTime);
            psRoom.setObject(4, endTime);
            psRoom.setObject(5, startTime);
            psRoom.setObject(6, endTime);

            rs=psRoom.executeQuery();
            while(rs.next()){
                roomID = rs.getInt("RoomId");
                roomType = rs.getString("RoomType");
                seatingCapacity = rs.getInt("SeatingCapacity");
//                for (Amenity amenity : amenities){
//                    amenityName = rs.getString("AmenityName");
//                    costPerHour = rs.getInt("CostPerHour");
//                    amenities.add(new Amenity(amenityName,costPerHour));
//                }
                availableRooms.add(new Room(roomID,roomType,seatingCapacity,amenities));
            }
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    // NOT REQUIRED
    @Override
    public void deleteRoom(int roomId) {

    }

    @Override
    public void updateRoom(Room room, int roomId) {

    }


    @Override
    public boolean isRoomAvailable(int roomId, LocalDateTime startTime, LocalDateTime endTime) {
        return false;
    }

    //totalCost will include seating capacity with all amenities per hour
    @Override
    public int getRoomBaseCost(int roomId) {
        int totalCost = 0;
        return totalCost;
    }
}
