
package dao.interfaces;

import exceptions.EntityNotFoundException;
import models.entities.Room;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomDaoIntf {
    public int createRoom(Room room);

    public Room getRoomDetails(int roomId);

    // not required
    public void deleteRoom(int roomId);

    // TODO: Required
    // NOTE: Update Room Type ID was of String but Model has Int as RoomID
    // NOTE : Require A getRoomWith ID
    public void updateRoom(Room room , int roomId);
    public Room getRoomWithID(int roomId) throws EntityNotFoundException;
    public List getRoomsAvailable(LocalDateTime startTime, LocalDateTime endTime);
    public boolean isRoomAvailable(int roomId, LocalDateTime startTime, LocalDateTime endTime);
    public int getRoomBaseCost(int roomId);
}