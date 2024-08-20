
package dao.interfaces;

import models.entities.Room;

import java.util.List;

public interface RoomDaoIntf {
    public int createRoom(Room room);
    public List getRoomsAvailable(String startTime, String endTime);
    public Room getRoomDetails(String roomId);
    public void updateRoom(Room room , String roomId);
    public void deleteRoom(String roomId);
}