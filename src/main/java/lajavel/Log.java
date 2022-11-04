package lajavel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Log {
    private static Log instance;
    private final Logger logger;
    private enum  Level {
        DEBUG(3),
        INFO(2),
        WARN(1),
        ERROR(0);

        public final int level;

        Level(int level) {
            this.level = level;
        }
    }

    public static void print(Level level, String message){
        int applicationLevel = Application.getInstance().mode.level;

        switch (level) {
            case INFO:
                if(applicationLevel >= Level.INFO.level)
                    getInstance().logger.info(message);
                break;
            case DEBUG:
                if(applicationLevel >= Level.DEBUG.level)
                    getInstance().logger.debug(message);
                break;
            case WARN:
                if (applicationLevel >= Level.WARN.level)
                    getInstance().logger.warn(message);
                break;
            case ERROR:
                if (applicationLevel >= Level.ERROR.level)
                    getInstance().logger.error(message);
                break;
        }
    }

    private Log() {
        // Instance un logger
        logger = LoggerFactory.getLogger("Lajavel");
    }


    private static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }
    public static void info(String msg){
        print(Level.INFO, msg);
    }
    public static void debug(String msg){
        print(Level.DEBUG, msg);
    }
    public static void warn(String msg){
        print(Level.WARN, msg);
    }
    public static void error(String msg){
        print(Level.ERROR, msg);
    }
}
