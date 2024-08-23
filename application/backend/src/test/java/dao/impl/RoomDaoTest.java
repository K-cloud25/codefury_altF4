package dao.impl;

import dao.interfaces.RoomDaoIntf;
import exceptions.EntityNotFoundException;
import factory.RoomFactory;
import models.entities.Room;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

}
