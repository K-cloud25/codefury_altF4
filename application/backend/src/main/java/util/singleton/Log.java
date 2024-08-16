package util.singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    public final static String logFilePath = "src/main/resources/logs.txt";
    public final static String errorFilePath = "src/main/resources/errors.txt";
    public final static String dateTimeFormat = "dd-MM-yyyy a k:mm:ss:n";

    public static void writeToLog(String logStmt){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(logFilePath, true))){

            String logStatement = LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateTimeFormat)) + " : "+  logStmt;
            bf.append(logStatement);
            bf.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeToError(String logStmt){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(errorFilePath, true))){

            String logStatement = LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateTimeFormat)) + " : "+  logStmt;
            bf.append(logStatement);
            bf.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
