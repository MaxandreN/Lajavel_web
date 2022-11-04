package lajavel;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Application {

    private static Application insance;
    public static Javalin server;
    public int port;
    public final Mode mode;

    public enum Mode {
        DEVELOPMENT(3),
        TEST(1),
        PRODUCTION(0);

        public final int level;

        Mode(int level) {this.level = level;}
    }


    private Application(int port, Mode mode){
        this.port = port;
        this.server = Javalin.create(config -> {
            config.addStaticFiles("public", Location.CLASSPATH);
        }).start(this.port);
        this.mode = mode;
    }

    public static Application start(int port, Mode mode){
        if (insance == null) {
            insance = new Application(port, mode);
            Log.info("Application started");
            return insance;
        } else {
            throw new RuntimeException("Application already started");
        }
    }

    public static Application getInstance() {
        if(insance == null) {
            throw new RuntimeException("Application not started");
        }
        return insance;
    }


}
