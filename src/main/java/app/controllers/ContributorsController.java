package app.controllers;

import app.models.Contributor;
import app.repository.ContributorsRepository;
import lajavel.Controller;
import lajavel.Response;
import lajavel.View;

import java.util.List;
import java.util.Map;

public class ContributorsController extends Controller {
    public void index(Response response) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        //get contributor
        List<Contributor> contributors = (List<Contributor>) ContributorsRepository.findall();


        response.html(View.make(
                "contributors",
                Map.entry("contributor1", contributors.get(0)),
                Map.entry("contributor2", contributors.get(1)),
                Map.entry("contributor3", contributors.get(2)),
                Map.entry("contributor4", contributors.get(3))
        ));
    }
}