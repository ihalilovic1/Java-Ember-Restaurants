package controllers;

import play.mvc.Result;

import views.html.*;


public class HomeController extends AbstractController {

    public Result index() {
        return ok(index.render());
    }

    public Result fileServer(String slug) {
        return ok(slug);
    }
}
