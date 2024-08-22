package models.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Meeting {
    private int meetingID;
    private int roomID;
    private int managerID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int costOfMeeting;
    private String description;

    private final static String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(dateTimeFormat);
    public Meeting() {

    }

    public Meeting(int meetingID, int roomID, int managerID, String startTime, String endTime, int costOfMeeting, String description) {
        this.meetingID = meetingID;
        this.roomID = roomID;
        this.managerID = managerID;
        //parse startTime and endTime and convert into  "yyyy-MM-dd HH:mm:ss" format
        this.startTime = LocalDateTime.parse(startTime);
        this.endTime = LocalDateTime.parse(endTime);
        this.costOfMeeting = costOfMeeting;
        this.description = description;
    }

    public Meeting(int meetingID, int roomID, int managerID, LocalDateTime startTime, LocalDateTime endTime, int costOfMeeting, String description) {
        this.meetingID = meetingID;
        this.roomID = roomID;
        this.managerID = managerID;
        //parse startTime and endTime and convert into  "yyyy-MM-dd HH:mm:ss" format
        this.startTime = startTime;
        this.endTime = endTime;
        this.costOfMeeting = costOfMeeting;
        this.description = description;
    }

    public int getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
    }

    //get roomId and return roomId
    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    //get startTime in LocalDateTime format
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalDateTime.parse(startTime);
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    //format startTime in "yyyy-MM-dd HH:mm:ss" format
    public String getFormattedStartTime(){
        return startTime.format(FORMATTER);
    }

    //format endTime in "yyyy-MM-dd HH:mm:ss" format
    public String getFormattedEndTime(){
        return endTime.format(FORMATTER);
    }


    public void setEndTime(String endTime) {
        this.endTime = LocalDateTime.parse(endTime);
    }

    public int getCostOfMeeting() {
        return costOfMeeting;
    }

    public void setCostOfMeeting(int costOfMeeting) {
        this.costOfMeeting = costOfMeeting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingID=" + meetingID +
                ", roomID=" + roomID +
                ", managerID=" + managerID +
                ", startTime=" + getFormattedStartTime() +
                ", endTime=" +getFormattedEndTime() +
                ", costOfMeeting=" + costOfMeeting +
                ", description='" + description + '\'' +
                '}';
    }
}
