package com.altfregistry.dao.factory;

import com.altfregistry.dao.impl.RoomDaoImpl;
import com.altfregistry.dao.interfaces.RoomDaoIntf;

public class RoomFactory {
    public static RoomDaoIntf getRoomDao() {
        return new RoomDaoImpl();
    }
}
