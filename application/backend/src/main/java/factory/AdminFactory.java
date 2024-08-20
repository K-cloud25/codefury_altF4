package factory;

import dao.impl.AdminDaoImpl;
import dao.interfaces.AdminDao;

public class AdminFactory {

    public static AdminDao getAdminDao() {
        return new AdminDaoImpl();
    }

}
