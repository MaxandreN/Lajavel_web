package app.controllers;

import lajavel.Controller;
import lajavel.Response;
import lajavel.View;

public class GettingStartedController  extends Controller {
    public void index(Response response) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        response.html(View.make("getting_started"));
    }
}
