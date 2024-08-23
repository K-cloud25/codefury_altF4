package dao.interfaces;

import exceptions.EntityNotFoundException;
import exceptions.InvalidCredentialsException;
import models.entities.Meeting;
import util.singleton.DatabaseConnector;

import java.sql.Connection;
import java.util.List;

public interface MemberIntf {

    public List<Meeting> getMeeting(int id) throws EntityNotFoundException, InvalidCredentialsException;

}
