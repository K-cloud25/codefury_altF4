package com.altfregistry.dao.factory;

import com.altfregistry.dao.impl.MeetingDaoImpl;
import com.altfregistry.dao.interfaces.MeetingDaoIntf;

public class MeetingFactory {
    public static MeetingDaoIntf getMeetingDao() {
        return new MeetingDaoImpl();
    }
}
