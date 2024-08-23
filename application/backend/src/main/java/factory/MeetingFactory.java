package factory;

import dao.impl.MeetingDaoImpl;
import dao.interfaces.MeetingDaoIntf;

public class MeetingFactory {
    public static MeetingDaoIntf getMeetingDao() {
        return new MeetingDaoImpl();
    }
}
