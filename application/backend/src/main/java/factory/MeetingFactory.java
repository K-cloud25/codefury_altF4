package factory;

import dao.interfaces.MeetingDaoIntf;
import models.entities.Amenity;
import models.entities.Meeting;

import java.util.List;

public class MeetingFactory {
    public static MeetingDaoIntf getMeetingDao() {
        return new MeetingDaoIntf() {
            @Override
            public void bookMeeting(int meetingId, int employeeId, List<Amenity> amenities) {

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
        };
    }
}
