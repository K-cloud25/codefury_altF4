package com.altfregistry.dao.factory;

import com.altfregistry.dao.impl.EmployeeDaoImpl;
import com.altfregistry.dao.interfaces.EmployeeDao;

public class EmployeeFactory {

    public static EmployeeDao getEmployeeDao() {
        return new EmployeeDaoImpl();
    }

}
