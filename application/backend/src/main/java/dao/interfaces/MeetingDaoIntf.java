package dao.interfaces;

import models.entities.Amenity;
import models.entities.Meeting;

import java.util.List;

public interface MeetingDaoIntf {
    public void bookMeeting(int meetingId, int employeeId, List<Amenity>amenities);
    public double calculateRatePerHour(Meeting meeting);
    Meeting getMeetingById(int meetingId);
    List<Meeting> getAllMeetings();
}
