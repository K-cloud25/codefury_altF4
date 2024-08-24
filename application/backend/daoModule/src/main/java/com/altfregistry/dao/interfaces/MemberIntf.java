package com.altfregistry.dao.interfaces;

import com.altfregistry.exceptions.EntityNotFoundException;
import com.altfregistry.exceptions.InvalidCredentialsException;
import com.altfregistry.model.entities.Meeting;

import java.util.List;

public interface MemberIntf {

    public List<Meeting> getMeeting(int id) throws EntityNotFoundException, InvalidCredentialsException;

}
