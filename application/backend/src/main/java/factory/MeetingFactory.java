package factory;

import dao.interfaces.MeetingDaoIntf;
import models.entities.Amenity;
import models.entities.Meeting;
import util.singleton.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingFactory {
    public static MeetingDaoIntf getMeetingDao() {
        return new MeetingDaoIntf() {

            @Override
            public int bookMeeting(Meeting meeting, int employeeId, List<Amenity> amenities) {
                return 0;
            }

            @Override
            public int calculateRatePerHour(Meeting meeting) {
                return 0;
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

                } catch (SQLException e) {

                    return null;
                }

                return listOfMeetings;
            }

            @Override
            public boolean isClashingMeeting(int roomId, LocalDateTime startTime, LocalDateTime endTime) {
                return false;
            }

            @Override
            public void addUsersToMeeting(int meetingID, List<Integer> empIds) {

            }
        };
    }
}
