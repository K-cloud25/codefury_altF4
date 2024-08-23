package factory;

import dao.impl.RoomDaoImpl;
import dao.interfaces.RoomDaoIntf;

public class RoomFactory {
    public static RoomDaoIntf getRoomDao() {
        return new RoomDaoImpl();
    }
}
