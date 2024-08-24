package com.altfregistry.dao.factory;

import com.altfregistry.dao.impl.ManagerDaoImpl;
import com.altfregistry.dao.interfaces.ManagerIntf;


public class ManagerFactory {
    public static ManagerIntf getManagerDao() {
        return new ManagerDaoImpl();
    }
}
