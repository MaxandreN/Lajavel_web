package app.controllers;

import app.models.Contributor;
import app.models.Partner;
import app.repository.ContributorsRepository;
import app.repository.PartnersRepository;
import lajavel.Controller;
import lajavel.Response;
import lajavel.View;

import java.util.List;
import java.util.Map;

public class PartnersController extends Controller {
    public void index(Response response) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        //get contributor
        List<Partner> partners = (List<Partner>) PartnersRepository.findall();


        response.html(View.make(
                "partners",
                Map.entry("partner1", partners.get(0)),
                Map.entry("partner2", partners.get(1)),
                Map.entry("partner3", partners.get(2)),
                Map.entry("partner4", partners.get(3))
        ));
    }
}