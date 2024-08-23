package factory;

import dao.impl.ManagerDaoImpl;
import dao.interfaces.ManagerIntf;

public class ManagerFactory {
    public static ManagerIntf getManagerDao() {
        return new ManagerDaoImpl();
    }
}
