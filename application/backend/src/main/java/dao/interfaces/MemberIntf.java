package dao.interfaces;

import exceptions.EntityNotFoundException;
import exceptions.InvalidCredentialsException;
import models.entities.Meeting;

public interface MemberIntf {

    public default Meeting getMeeting(int id) throws EntityNotFoundException, InvalidCredentialsException
    {
        
        return null;
    }


}
