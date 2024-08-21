package dao.interfaces;

import exceptions.EntityNotFoundException;
import exceptions.InsufficientCreditsException;
import models.entities.Meeting;
import models.entities.Room;

import java.time.LocalDateTime;

import java.util.List;

    public interface ManagerIntf {

    public Room getRoomSlot(LocalDateTime startTime, LocalDateTime endTime) throws InsufficientCreditsException;

    public List<models.users.Member> getMembersInSlot(LocalDateTime startTime, LocalDateTime endTime);

    public boolean requestRoom(int roomId, LocalDateTime startTime, LocalDateTime endTime, List<models.users.Member> members) throws InsufficientCreditsException;

    public List<Meeting> checkMeeting() throws EntityNotFoundException;

    public int checkCredits();

    public int modifyCredits(int credits);
}
