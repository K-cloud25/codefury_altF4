package com.altfregistry.dao.interfaces;

import com.altfregistry.model.entities.Meeting;
import com.altfregistry.model.entities.Amenity;
import java.time.LocalDateTime;
import java.util.List;

public interface MeetingDaoIntf {
    public int bookMeeting(Meeting meeting,  int employeeId, List<Amenity>amenities);
    Meeting getMeetingById(int meetingId);
    List<Meeting> getAllMeetings();

    // Requesting
    // Writes meeting relations to DB and creates Records
    public void addUsersToMeeting( int meetingID, List<Integer> empIds );
}
