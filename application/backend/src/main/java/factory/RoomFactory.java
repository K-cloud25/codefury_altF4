package factory;

import dao.interfaces.RoomDaoIntf;
import exceptions.EntityNotFoundException;
import models.entities.Room;

import java.time.LocalDateTime;
import java.util.List;

public class RoomFactory {
    public static RoomDaoIntf getRoomDao() {
        return new RoomDaoIntf() {

            @Override
            public int createRoom(Room room) {
                return 0;
            }

            @Override
            public Room getRoomDetails(int roomId) {
                return null;
            }

            @Override
            public void deleteRoom(int roomId) {

            }

            @Override
            public void updateRoom(Room room, int roomId) {

            }

            @Override
            public Room getRoomWithID(int roomId) throws EntityNotFoundException {
                return null;
            }

            @Override
            public List getRoomsAvailable(LocalDateTime startTime, LocalDateTime endTime) {
                return List.of();
            }

            @Override
            public boolean isRoomAvailable(int roomId, LocalDateTime startTime, LocalDateTime endTime) {
                return false;
            }

            @Override
            public int getRoomBaseCost(int roomId) {
                return 0;
            }
        };
    }
}
