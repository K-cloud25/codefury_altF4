package dao.impl;

import dao.interfaces.RoomDaoIntf;
import exceptions.EntityNotFoundException;
import factory.RoomFactory;
import models.entities.Room;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoomDaoTest {

    @Test
    @DisplayName("Room Dao Test : create Room ")
    public void testCaseA() {

        RoomDaoIntf rmIntf = RoomFactory.getRoomDao();

        int id = rmIntf.createRoom( new Room( -1, "classroomtraining", 20 ) );

        assertNotEquals(-1, id);

    }

    @Test
    @DisplayName("Room Dao Test : getRoomWithID")
    public void testCaseB() {
        RoomDaoIntf rmIntf = RoomFactory.getRoomDao();

        try {
            Room rm = rmIntf.getRoomWithID(1);
            assertNotNull(rm);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    @DisplayName("Room Dao Test : getRoomsAvailable")
    public void testCaseC() {
        RoomDaoIntf rmIntf = RoomFactory.getRoomDao();
        // Current Date Time
        LocalDateTime startTimeStamp = LocalDateTime.now();
        // Current Date with time set to 3 hours ahead
        LocalDateTime endTimeStamp = LocalDateTime.now().plusHours(3);
        List<Room> rooms = rmIntf.getRoomsAvailable(startTimeStamp, endTimeStamp);
        assertNotNull(rooms);
        System.out.println(rooms);

    }

    @Test
    @DisplayName("Room Dao Test : isRoomAvailable")
    public void testCaseD() {
        RoomDaoIntf rmIntf = RoomFactory.getRoomDao();
        LocalDateTime startTimeStamp = LocalDateTime.now();
        LocalDateTime endTimeStamp = LocalDateTime.now().plusHours(3);
        int roomIDToBeChecked = 1;

        assertFalse(rmIntf.isRoomAvailable(roomIDToBeChecked, startTimeStamp, endTimeStamp));

    }

}
