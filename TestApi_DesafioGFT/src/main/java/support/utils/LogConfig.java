package support.utils;

public class LogConfig {
    public enum LogLevel {
        INFO, ERROR, DEBUG
    }

    private static LogLevel logLevel = LogLevel.DEBUG;

    public static LogLevel getLogLevel() {
        return logLevel;
    }

    public static void setLogLevel(LogLevel level) {
        logLevel = level;
    }
}
