package factory;

import dao.impl.MemberDaoImpl;
import dao.interfaces.MemberIntf;

public class MemberFactory {

    public static MemberIntf getMemberDao(){
        return new MemberDaoImpl();
    }
}
