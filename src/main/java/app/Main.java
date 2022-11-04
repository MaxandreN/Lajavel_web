package app;

import app.controllers.*;
import lajavel.*;

import java.io.IOException;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        //open port
        Application app = Application.start(7071, Application.Mode.DEVELOPMENT);

        //request
        Route.register(HttpVerb.GET, "/", IndexController.class, "index");
        Route.register(HttpVerb.GET, "/contributors", ContributorsController.class, "index");
        Route.register(HttpVerb.GET, "/partners", PartnersController.class, "index");
        Route.register(HttpVerb.GET, "/getting_started", GettingStartedController.class, "index");

    }
}