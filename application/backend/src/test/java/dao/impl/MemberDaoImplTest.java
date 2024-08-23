package dao.impl;

import exceptions.EntityNotFoundException;
import models.entities.Meeting;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.singleton.DatabaseConnector;
import util.singleton.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MemberDaoImplTest {

    private static MemberDaoImpl dao;
    private static Connection conn = null;
    private static PreparedStatement psMeeting = null;;
    private static ResultSet rs = null;
    private static final int employeeId=101;
    private static int falseEmployeeId;
    private final static String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(dateTimeFormat);
    private static String startTime;
    private static String endTime;
    private static int costOfMeeting;
    private static String description;
    private static int meetingId;
    private static int roomId;


    @BeforeAll
    public static void init() {
        // Init The Common resources across all the tests
        dao = new MemberDaoImpl();
        conn = DatabaseConnector.getConnection();
        falseEmployeeId = 102;
        LocalDateTime t1 = LocalDateTime.now();
        LocalDateTime t2 = LocalDateTime.now().plusDays(1).plusHours(1);
        startTime = t1.format(FORMATTER);
        endTime = t2.format(FORMATTER);
        costOfMeeting = 100;
        description = "Sprint Meeting";
        meetingId = 1;
        roomId = 1;
        String query = """
                INSERT INTO meeting (`roomID`, `managerID`, `startTime`, `endTime`, `costOfMeeting`, `descrip`, `meetingID`)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;

        try {

            psMeeting = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            psMeeting.setInt(1, roomId);
            psMeeting.setInt(2, employeeId);
            psMeeting.setString(3, startTime);
            psMeeting.setString(4, endTime);
            psMeeting.setInt(5, costOfMeeting);
            psMeeting.setString(6, description);
            psMeeting.setInt(7, meetingId);

            int rowsAffected = psMeeting.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Member dao test: Meeting found")
    public void testFindById() throws EntityNotFoundException {

        List<Meeting> meetings = new ArrayList<>();


        String sql =
                """
            SELECT m.meetingID, m.roomID, m.managerID, m.startTime, m.endTime, m.costOfMeeting, m.descrip\s
            FROM meeting m\s
            JOIN\s
            	mapMeetingUser mmu ON m.meetingID = mmu.meetingID
            WHERE mmu.empID = ?;
    """;

        try {
            int meetingId;
            int roomId;
            int managerId;
            LocalDateTime startTime;
            LocalDateTime endTime;
            int costOfMeeting;
            String description;
            psMeeting = conn.prepareStatement(sql);
            psMeeting.setInt(1, falseEmployeeId);
            rs = psMeeting.executeQuery();

            while (rs.next()) {
                meetingId = rs.getInt("meetingID");
                roomId = rs.getInt("roomID");
                managerId = rs.getInt("managerID");
                startTime = rs.getObject("startTime", LocalDateTime.class);
                endTime = rs.getObject("endTime", LocalDateTime.class);
                costOfMeeting = rs.getInt("costOfMeeting");
                description = rs.getString("descrip");
                meetings.add(new Meeting(meetingId,roomId,managerId,startTime,endTime,costOfMeeting,description));
            }
        } catch (SQLException e) {
            throw new EntityNotFoundException("No meetings found for memberid");
        }
        List<Meeting> trueMeetings = Arrays.asList(new Meeting(meetingId,roomId,employeeId,startTime,endTime,costOfMeeting,description));
        assertNotEquals(trueMeetings,meetings);

    }

    @Test
    @DisplayName("Member dao test: Meeting found")
    public void testFindById2() throws EntityNotFoundException {
        List<Meeting> meetings = new ArrayList<>();


        String sql =
                """
            SELECT m.meetingID, m.roomID, m.managerID, m.startTime, m.endTime, m.costOfMeeting, m.descrip\s
            FROM meeting m\s
            JOIN\s
            	mapMeetingUser mmu ON m.meetingID = mmu.meetingID
            WHERE mmu.empID = ?;
    """;

        try {
            int meetingId;
            int roomId;
            int managerId;
            LocalDateTime startTime;
            LocalDateTime endTime;
            int costOfMeeting;
            String description;
            psMeeting = conn.prepareStatement(sql);
            psMeeting.setInt(1, employeeId);
            rs = psMeeting.executeQuery();

            while (rs.next()) {
                meetingId = rs.getInt("meetingID");
                roomId = rs.getInt("roomID");
                managerId = rs.getInt("managerID");
                startTime = rs.getObject("startTime", LocalDateTime.class);
                endTime = rs.getObject("endTime", LocalDateTime.class);
                costOfMeeting = rs.getInt("costOfMeeting");
                description = rs.getString("descrip");
                meetings.add(new Meeting(meetingId,roomId,managerId,startTime,endTime,costOfMeeting,description));
            }
        } catch (SQLException e) {
            throw new EntityNotFoundException("No meetings found for memberid");
        }
        List<Meeting> trueMeetings = Arrays.asList(new Meeting(meetingId,roomId,employeeId,startTime,endTime,costOfMeeting,description));
        assertEquals(trueMeetings,meetings);
    }



    @AfterAll
    public static void destroy(){
        // removing pointer from instance for cleanup;
        System.gc();    // Hinting at required for cleanup by garbage collector
        dao = null;
    }
}
