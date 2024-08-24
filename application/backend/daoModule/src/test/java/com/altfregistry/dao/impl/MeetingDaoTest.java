package com.altfregistry.dao.impl;

import com.altfregistry.dao.factory.MeetingFactory;
import com.altfregistry.dao.interfaces.MeetingDaoIntf;
import com.altfregistry.model.entities.Amenity;
import com.altfregistry.model.entities.Meeting;
import com.altfregistry.singleton.DatabaseConnector;
import com.altfregistry.singleton.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MeetingDaoTest {
    private static MeetingDaoImpl dao;

    @BeforeAll
    public static void init(){
        dao = new MeetingDaoImpl();
    }
    @Test
    @DisplayName("Meeting Dao Test : Book meeting")
    public void testA(){

            MeetingDaoIntf meetIntf = MeetingFactory.getMeetingDao();
                Meeting meeting = new Meeting(42513,1,1,"2024-08-24 09:00:00","2024-08-24 11:00:00",5,"Projector : 1");
            int empId=1;
            List<Amenity> amenityList=new ArrayList<>();
            int result = meetIntf.bookMeeting(meeting,empId,amenityList);
            assertEquals(1,result);
    }


//    @Test
//    @DisplayName("Meeting Dao Test : get Meeting By ID")
//    public void testB(){
//        MeetingDaoIntf meetIntf = MeetingFactory.getMeetingDao();
//    }

    @Test
    @DisplayName("Meeting Dao Test : Get All Meeting")
    public void testC(){
        MeetingDaoIntf meetIntf = MeetingFactory.getMeetingDao();
        List<Meeting> meetingList=meetIntf.getAllMeetings();
        assertNotNull(meetingList); //check is meetingList is null or not and display all meetings
        System.out.println(meetingList);
    }

    @Test
    @DisplayName("Meeting Dao Test : Add Users To Meeting")
    public void testD(){
        MeetingDaoIntf meetIntf = MeetingFactory.getMeetingDao();
        int meetingId=1;
        List<Integer> empIdList= Arrays.asList(1,2,3);
        meetIntf.addUsersToMeeting(meetingId,empIdList);

        // Validate the result
        Connection conn = DatabaseConnector.getConnection();
        PreparedStatement ps = null;

        String query = "INSERT INTO mapmeetinguser VALUE (?, ?)";
        try{
            ps = conn.prepareStatement(query);
            ps.setInt(1,meetingId);
            try(ResultSet rs = ps.executeQuery()){
                int count=0;
                while(rs.next()){
                    assertTrue(empIdList.contains(rs.getInt("empID")));
                    assertEquals(meetingId, rs.getInt("meetingID"));
                    count++;
                }
                assertEquals(empIdList.size(), count);
            }
            ps.close();

        } catch (SQLException e) {
            Log.writeToError("MySQL Error : " + e.getMessage());
        }
    }

    @AfterAll
    public static void destroy(){
        // removing pointer from instance for cleanup;
        System.gc();    // Hinting at required for cleanup by garbage collector
        dao = null;
    }
}
