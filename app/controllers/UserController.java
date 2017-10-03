package controllers;

import forms.LoginForm;
import models.tables.User;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.UserService;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static play.mvc.Results.ok;

public class UserController extends AbstractController {

    private UserService userService;
    private FormFactory formFactory;

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Inject
    public void setFormFactory(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    @Transactional
    public Result getMe() {

        User result = userService.getUser();

        return ok(Json.toJson(result.getCity().getCountry().getName()));
    }

    @Transactional
    public Result register() {
        userService.register();
        return ok();
    }

    @Transactional
    public Result login() {
        Form<LoginForm> loginForm = formFactory.form(LoginForm.class);
        User result = userService.login(loginForm.bindFromRequest().get());
        return ok(result.getFirstName() + " " + result.getLastName());
    }

}
