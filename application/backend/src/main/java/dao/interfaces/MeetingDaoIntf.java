package dao.interfaces;

import exceptions.EntityNotFoundException;
import models.entities.Amenity;
import models.entities.Meeting;
import models.entities.Room;

import java.time.LocalDateTime;
import java.util.List;

public interface MeetingDaoIntf {
    public int bookMeeting(Meeting meeting,  int employeeId, List<Amenity>amenities);
    public double calculateRatePerHour(Meeting meeting);
    Meeting getMeetingById(int meetingId);
    List<Meeting> getAllMeetings();

    // Requesting

    // Checks if Any Meeting within the same time slot has the same room aka: Clash Booking]
    // True if Clash False if Clear
    public boolean isClashingMeeting(int roomId, LocalDateTime startTime, LocalDateTime endTime);

    // Writes meeting relations to DB and creates Records
    public void addUsersToMeeting( int meetingID, List<Integer> empIds );
}
