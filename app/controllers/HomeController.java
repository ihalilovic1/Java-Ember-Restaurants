package controllers;

import play.mvc.Result;

import views.html.*;


public class HomeController extends AbstractController {

    public Result index(String slug) {
        return ok(index.render());
    }

}
