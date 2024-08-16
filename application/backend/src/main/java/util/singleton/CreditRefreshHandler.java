package util.singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.*;
import java.util.Timer;
import java.util.TimerTask;

// Instantiated At Creation of Service Layer OBJ
public class CreditRefreshHandler {

    private final static long weekInMilliSec = 7 * 24 * 60 * 60 * 1000L; // 7 days in milliseconds
    private final Connection cnx;

    public CreditRefreshHandler() {

        long delayForFnx = getDelayForNextEvent();

        cnx = DatabaseConnector.getConnection();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Your code to be executed every Monday at 9 AM
                Log.writeToLog("Refreshing Credits Of Managers");

                String query = "UPDATE credit SET creditVal = 2000";
                PreparedStatement ps = null;
                try {
                    ps = cnx.prepareStatement(query);
                    ps.executeUpdate();
                    } catch (SQLException e) {
                    Log.writeToError(e.getMessage() + " " + e.getErrorCode() + " " + e.getSQLState());
                }

                Log.writeToLog("Credits Refreshed");
            }
        };


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, delayForFnx, weekInMilliSec);
    }

    // Calculates Time Delay between time.now() and next Monday
    private long getDelayForNextEvent(){

        // Local date time object for current timestamp
        LocalDateTime now = LocalDateTime.now();
        // Local date time object set on an adjustment to a Monday and at 9 am
        LocalDateTime nextMonday = now.with(DayOfWeek.MONDAY).with(LocalTime.of(9,0));

        // Adjustment made by the class maybe negative or positive
        // If statement makes sure it points to next upcoming monday
        if ( now.isAfter(nextMonday) ) {
            nextMonday = nextMonday.plusWeeks(1);   // Adds a week offset to the datetime object
        }

        return Duration.between(now, nextMonday).toMillis();    // returns time difference in Milliseconds
    }


}
