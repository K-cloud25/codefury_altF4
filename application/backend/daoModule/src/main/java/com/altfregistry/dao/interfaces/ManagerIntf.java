package com.altfregistry.dao.interfaces;

import com.altfregistry.exceptions.EntityNotFoundException;
import com.altfregistry.model.entities.Meeting;
import com.altfregistry.model.users.Member;

import java.time.LocalDateTime;

import java.util.List;

    public interface ManagerIntf {

    public List<Member> getMembersInSlot(LocalDateTime startTime, LocalDateTime endTime);

    public List<Meeting> checkMeeting(int id) throws EntityNotFoundException;

    public int checkCredits(int id);

    public int modifyCredits(int credits, int id);
}
