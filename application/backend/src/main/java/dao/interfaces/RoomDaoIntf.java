
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

    public boolean updateRoom(Room room , int roomId);
    public Room getRoomWithID(int roomId) throws EntityNotFoundException;
    public List<Room> getRoomsAvailable(LocalDateTime startTime, LocalDateTime endTime);
    public boolean isRoomAvailable(int roomId, LocalDateTime startTime, LocalDateTime endTime);
    public int getRoomBaseCost(String roomType);
}