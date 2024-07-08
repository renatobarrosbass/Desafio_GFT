package support.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
    private static final String LOG_FOLDER = "LogFiles";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    private String logFileName;

    public LogWriter() {
        String date = LocalDateTime.now().format(DATE_FORMATTER);
        logFileName = LOG_FOLDER + "/logFile_" + date + ".txt";
        createLogFolder();
    }

    private void createLogFolder() {
        File folder = new File(LOG_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public void log(String level, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFileName, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(String.format("%s [%s] %s", timestamp, level, message));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    public void debug(String message) {
        log("DEBUG", message);
    }
}
