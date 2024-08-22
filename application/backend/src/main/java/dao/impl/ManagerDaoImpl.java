package dao.impl;

import dao.interfaces.ManagerIntf;
import exceptions.EntityNotFoundException;
import exceptions.InsufficientCreditsException;
import models.entities.Meeting;
import models.entities.Room;
import models.users.Member;
import util.singleton.DatabaseConnector;
import util.singleton.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl implements ManagerIntf {

    Connection conn = DatabaseConnector.getConnection();

    @Override
    public List<Room> getRoomSlot(LocalDateTime startTime, LocalDateTime endTime){

        String sql = "SELECT r.roomID, r.roomType, r.seatinCapacity" +
                "FROM room r " +
                "WHERE r.roomId NOT IN("+
                    "SELECT m.rooID"+
                    "FROM meeting m"+
                    "WHERE"+
                    "(m.startTime BETWEEN ? AND ?)"+
                    "OR"+
                    "(m.endTime BETWEEN ? AND ?)"+
                    "OR"+
                    "(? BETWEEN m.startTime AND m.endTime"+
                    "OR"+
                    "(? BETWEEN m.startTime AND m.endTime)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Room> rooms = new ArrayList<>();

        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, startTime);
            ps.setObject(2, endTime);
            ps.setObject(3,startTime);
            ps.setObject(4,endTime);
            ps.setObject(5,startTime);
            ps.setObject(6,endTime);

            rs = ps.executeQuery();

            while (rs.next()) {
                int roomId = rs.getInt("roomID");
                String roomType = rs.getString("roomType");
                int seatinCapacity = rs.getInt("seatinCapacity");
                rooms.add(new Room(roomId,roomType,seatinCapacity,null));
            }
        } catch (SQLException e) {
            Log.writeToError("Failed to fetch rooms");
            throw new RuntimeException(e);
        }

        Log.writeToLog("Available rooms successfully returned ");
        return rooms;

    }

    @Override
    public List<Member> getMembersInSlot(LocalDateTime startTime, LocalDateTime endTime) {

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

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Member> members = new ArrayList<>();

        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, startTime);
            ps.setObject(2, endTime);
            ps.setObject(3, startTime);
            ps.setObject(4, endTime);
            ps.setObject(5, startTime);
            ps.setObject(6, endTime);

            rs = ps.executeQuery();
            while (rs.next()) {
                int empID = rs.getInt("empID");
                String empName = rs.getString("empName");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int empType = rs.getInt("empType");
                String passwd = rs.getString("passwd");
                members.add(new Member(empID,empName,email,phone,empType,passwd));
            }
        }
        catch (SQLException e) {
            Log.writeToError("Failed to fetch members");
            throw new RuntimeException(e);
        }

        Log.writeToLog("Available members successfully returned ");
        return members;
    }

    @Override
    public boolean requestRoom(int roomId, LocalDateTime startTime, LocalDateTime endTime, List<Member> members) throws InsufficientCreditsException {
        return false;
    }

    @Override
    public List<Meeting> checkMeeting(int id) throws EntityNotFoundException {

        Log.writeToLog("Starting to fetch meetings based on manager Id "+id);

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Meeting> meetings = new ArrayList<>();
        int meetingId;
        int roomId;
        int managerId;
        LocalDateTime startTime;
        LocalDateTime endTime;
        int costOfMeeting;
        String description;

        String sql = "SELECT m.meetingID, m.roomID, m.managerID, m.startTime, m.endTime, m.costOfMeeting, m.descrip " +
                "FROM meeting m " +
                "JOIN " +
                "mapMeetingUser mmu ON m.meetingID = mmu.meetingID" +
                "WHERE mmu.empID = ?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                meetingId = rs.getInt("meetingID");
                roomId = rs.getInt("roomID");
                managerId = rs.getInt("managerID");
                startTime = rs.getObject("startTime", LocalDateTime.class);
                endTime = rs.getObject("endTime", LocalDateTime.class);
                costOfMeeting = rs.getInt("costOfMeeting");
                description = rs.getString("descrip");
                meetings.add(new Meeting(meetingId,roomId,managerId,startTime,endTime,costOfMeeting,description));
            }
        } catch (SQLException e) {
            Log.writeToError("Error fetching meetings based on memberid");
            throw new EntityNotFoundException("No meetings found for memberid");
        }


        Log.writeToLog("Meetings fetched successfully");
        return meetings;

    }

    @Override
    public int checkCredits(int id) {

        Log.writeToLog("Retrieving credits based on manager Id "+id);
        String sql = "SELECT credit "
                +"FROM credit"
                +"WHERE empID = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        int credits;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            credits = rs.getInt("credit");

        } catch (SQLException e) {
            Log.writeToError("Error fetching credits based on id "+id);
            throw new RuntimeException(e);
        }

        Log.writeToLog("Credits fetched successfully");
        return credits;

    }

    @Override
    public int modifyCredits(int credits, int id) {

        Log.writeToLog("Updating credits for manager Id "+id);
        String sql = "UPDATE credit "
                +"SET credit = ?"
                +"WHERE empID = ?";

        PreparedStatement ps = null;
        int result;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, credits);
            ps.setInt(2, id);
            result = ps.executeUpdate();

        } catch (SQLException e) {
            Log.writeToError("Error updating credits based of id "+id);
            throw new RuntimeException(e);
        }

        if(result<=0)
            Log.writeToError("Error updating credits for id "+id);
        else
            Log.writeToLog("Credits updated successfully");
        return credits;

    }
}
