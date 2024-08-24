package com.altfregistry.dao.impl;

import com.altfregistry.dao.interfaces.MeetingDaoIntf;
import com.altfregistry.model.entities.Meeting;
import com.altfregistry.model.entities.Amenity;
import com.altfregistry.singleton.Log;
import com.altfregistry.singleton.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingDaoImpl implements MeetingDaoIntf {
    Connection conn = DatabaseConnector.getConnection();
    PreparedStatement psMeeting = null;;
    ResultSet rs = null;


    @Override
    public int bookMeeting(Meeting meeting, int employeeId, List<Amenity> amenities) {

        Connection conn = DatabaseConnector.getConnection();
        PreparedStatement psMeeting = null;

        String query = """
                INSERT INTO meeting (`roomID`, `managerID`, `startTime`, `endTime`, `costOfMeeting`, `descrip`, `meetingID`)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;

        try{

            psMeeting = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            psMeeting.setInt(1, meeting.getRoomID());
            psMeeting.setInt(2, employeeId);
            psMeeting.setString(3, meeting.getFormattedStartTime());
            psMeeting.setString(4, meeting.getFormattedEndTime());
            psMeeting.setInt(5, meeting.getCostOfMeeting());
            psMeeting.setString(6, meeting.getDescription());
            psMeeting.setInt(7, meeting.getMeetingID());
            int rowsAffected = psMeeting.executeUpdate();
            psMeeting.close();

            if ( rowsAffected < 0) {
                Log.writeToError("Meeting not Added");
                return -1;
            }
            else{
                return 1;
            }

        } catch (SQLException e) {
            Log.writeToError("MySQL Error : " + e.getMessage());
            return -1;
        }

    }

    @Override
    public Meeting getMeetingById(int meetingId) {
        return null;
    }

    @Override
    public List<Meeting> getAllMeetings() {
        Connection cnx = DatabaseConnector.getConnection();
        PreparedStatement ps = null;
        String query = "SELECT * FROM meeting";
        ArrayList<Meeting> listOfMeetings = new ArrayList<>();

        try{
            ps = cnx.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while( rs.next() ) {

                int meetingID = rs.getInt("meetingID");
                int roomID = rs.getInt("roomID");
                int managerID = rs.getInt("managerID");
                String startTime = rs.getString("startTime");
                String endTime = rs.getString("endTime");
                int costOfMeeting = rs.getInt("costOfMeeting");
                String description = rs.getString("descrip");

                Meeting meeting = new Meeting(meetingID, roomID, managerID, startTime, endTime,costOfMeeting,description);
                listOfMeetings.add(meeting);
            }

            ps.close();

        } catch (SQLException e) {

            return null;
        }

        return listOfMeetings;
    }

    @Override
    public void addUsersToMeeting(int meetingID, List<Integer> empIds) {
        Connection conn = DatabaseConnector.getConnection();
        PreparedStatement ps = null;

        String query = "INSERT INTO mapmeetinguser VALUE (?, ?)";
        try{
            ps = conn.prepareStatement(query);

            for( int i : empIds ) {
                ps.setInt(2, meetingID);
                ps.setInt(1, i);

                ps.executeUpdate();
            }

            ps.close();

        } catch (SQLException e) {
            Log.writeToError("MySQL Error : " + e.getMessage());
        }
    }
}
