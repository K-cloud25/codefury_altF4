package dao.impl;

import dao.interfaces.MemberIntf;
import exceptions.EntityNotFoundException;
import exceptions.InvalidCredentialsException;
import models.entities.Meeting;
import util.singleton.DatabaseConnector;
import util.singleton.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberIntf {


    /*This function accepts the entered employee id and returns the list of meetings the employee is a part of.
    * It logs error messages and throws the entity not found exception and Invalid credentials exception*/

    @Override
    public List<Meeting> getMeeting(int id) throws EntityNotFoundException, InvalidCredentialsException {

        Log.writeToLog("Starting to fetch meetings based on employee Id");
        Connection conn = DatabaseConnector.getConnection();
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

        String sql =
                """
            SELECT m.meetingID, m.roomID, m.managerID, m.startTime, m.endTime, m.costOfMeeting, m.descrip\s
            FROM meeting m\s
            JOIN\s
            	mapMeetingUser mmu ON m.meetingID = mmu.meetingID
            WHERE mmu.empID = ?;
    """;

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
            Log.writeToError("Error fetching meetings based on memberid : " + e.getMessage() + " : " + e.getSQLState());
            throw new EntityNotFoundException("No meetings found for memberid");
        }

        Log.writeToLog("Meetings fetched successfully");
        return meetings;

    }
}
