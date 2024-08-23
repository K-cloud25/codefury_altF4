package dao.impl;

import dao.interfaces.MeetingDaoIntf;
import models.entities.Amenity;
import models.entities.Meeting;
import util.singleton.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

public class MeetingDaoImpl implements MeetingDaoIntf {
    Connection conn = DatabaseConnector.getConnection();
    PreparedStatement psMeeting = null;;
    ResultSet rs = null;


    @Override
    public int bookMeeting(Meeting meeting, int employeeId, List<Amenity> amenities) {
        return 0;
    }

    @Override
    public double calculateRatePerHour(Meeting meeting) {
        return 0;
    }

    @Override
    public Meeting getMeetingById(int meetingId) {
        return null;
    }

    @Override
    public List<Meeting> getAllMeetings() {
        return List.of();
    }

    @Override
    public boolean isClashingMeeting(int roomId, LocalDateTime startTime, LocalDateTime endTime) {
        return false;
    }

    @Override
    public void addUsersToMeeting(int meetingID, List<Integer> empIds) {

    }
}
