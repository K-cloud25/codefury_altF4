package util.singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    // Static Vars for file utility.
    private final static String logFilePath = "src/main/resources/logs.txt";
    private final static String errorFilePath = "src/main/resources/errors.txt";
    private final static String dateTimeFormat = "dd-MM-yyyy a k:mm:ss:n";


    // Writes Log Texts into logs.txt file
    public static void writeToLog(String logStmt){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(logFilePath, true))){

            String logStatement = LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateTimeFormat)) + " : "+  logStmt;
            bf.append(logStatement);
            bf.newLine();

        } catch (IOException e) {
            System.out.println("Error Occurred During Logging " + e.getMessage() + " \n stmt :  " + logStmt);
        }

    }

    // Writes Error Texts into errors.txt file
    public static void writeToError(String logStmt){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(errorFilePath, true))){

            String logStatement = LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateTimeFormat)) + " : "+  logStmt;
            bf.append(logStatement);
            bf.newLine();

        } catch (IOException e) {
            System.out.println("Error Occurred During Logging " + e.getMessage() + " \n stmt :  " + logStmt);
        }

    }

}
