package app.controllers;

import lajavel.Response;
import lajavel.View;

public class GettingStartedController {
    public void index(Response response) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        response.html(View.make("getting_started"));
    }
}
