package seedu.duke.log;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//@@author SeanRobertDH
public class Log {

    private static final Level DEFAULT_CONSOLE_SEVERITY = Level.SEVERE;
    private static final Level DEFAULT_LOG_FILE_SEVERITY = Level.FINE;
    private static final String LOG_FILE_NAME = "log.txt";
    private static final String LOG_FORMAT = "[%1$tF %1$tT] [%2$-7s]%n%3$s %n";
    private static final String IOEXCEPTION_MESSAGE = "Failed to initialise log file.";

    private static final int METHOD_STACKTRACE_POSITION = 3;

    private static final boolean DO_APPEND_TO_FILE = true;
    private static final boolean USE_DEFAULT_HANDLERS = false;

    private static HashMap<String, Logger> loggers = new HashMap<>();

    private static FileHandler getFileHandler() throws IOException {
        FileHandler fileHandler = new FileHandler(LOG_FILE_NAME, DO_APPEND_TO_FILE);
        fileHandler.setLevel(DEFAULT_LOG_FILE_SEVERITY);
        return fileHandler;
    }

    private static Logger getLogger() {
        StackTraceElement classToLog = Thread.currentThread().getStackTrace()[METHOD_STACKTRACE_POSITION];
        String className = classToLog.getClassName();
        if (loggers.containsKey(className)) {
            return loggers.get(className);
        } else {
            return createLogger(className);
        }
    }

    private static Logger createLogger(String className) {
        Logger logger = Logger.getLogger(className);
        logger.setUseParentHandlers(USE_DEFAULT_HANDLERS);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(DEFAULT_CONSOLE_SEVERITY);

        consoleHandler.setFormatter(getLogFormat());

        logger.addHandler(consoleHandler);

        loggers.put(className, logger);
        return logger;
    }

    private static SimpleFormatter getLogFormat() {
        return new SimpleFormatter() {
            private static final String format = LOG_FORMAT;

            @Override
            public synchronized String format(
                LogRecord logRecord) {
                return String.format(format, new Date(logRecord.getMillis()),
                    logRecord.getLoggerName(), logRecord.getMessage());
            }
        };
    }

    private static void logMessage(Level level, String message) {
        Logger logger = getLogger();
        try {
            FileHandler fileHandler = getFileHandler();
            fileHandler.setFormatter(getLogFormat());
            logger.addHandler(fileHandler);
            logger.log(level, message);
            fileHandler.close();
        } catch (IOException ioe) {
            //The console logger still works, so we log a message to console.
            logger.severe(IOEXCEPTION_MESSAGE);
        }
    }

    public static void finest(String message) {
        logMessage(Level.FINEST, message);
    }

    public static void finer(String message) {
        logMessage(Level.FINER, message);
    }

    public static void fine(String message) {
        logMessage(Level.FINE, message);
    }

    public static void info(String message) {
        logMessage(Level.INFO, message);
    }

    public static void warning(String message) {
        logMessage(Level.WARNING, message);
    }

    public static void severe(String message) {
        logMessage(Level.SEVERE, message);
    }
}
