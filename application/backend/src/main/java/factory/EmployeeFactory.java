package factory;

import dao.impl.EmployeeDaoImpl;
import dao.interfaces.EmployeeDao;

public class EmployeeFactory {

    public static EmployeeDao getEmployeeDao() {
        return new EmployeeDaoImpl();
    }

}
