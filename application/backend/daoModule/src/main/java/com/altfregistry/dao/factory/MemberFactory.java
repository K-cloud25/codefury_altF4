package com.altfregistry.dao.factory;

import com.altfregistry.dao.impl.MemberDaoImpl;
import com.altfregistry.dao.interfaces.MemberIntf;

public class MemberFactory {

    public static MemberIntf getMemberDao(){
        return new MemberDaoImpl();
    }
}
