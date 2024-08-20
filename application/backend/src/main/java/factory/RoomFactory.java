package factory;

import dao.interfaces.RoomDaoIntf;
import models.entities.Room;

import java.util.List;

public class RoomFactory {
    public static RoomDaoIntf getRoomDao() {
        return new RoomDaoIntf() {
            @Override
            public int createRoom(Room room) {
            return 0;
            }

            @Override
            public List getRoomsAvailable(String startTime, String endTime) {
                return List.of();
            }

            @Override
            public Room getRoomDetails(String roomId) {
                return null;
            }

            @Override
            public void updateRoom(Room room, String roomId) {

            }

            @Override
            public void deleteRoom(String roomId) {

            }
        };
    }
}
