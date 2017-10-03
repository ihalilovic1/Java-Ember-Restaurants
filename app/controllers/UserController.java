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
    public Result register() {
        userService.register();
        return ok();
    }

    @Transactional
    public Result login() {
        try {
            Form<LoginForm> loginForm = formFactory.form(LoginForm.class);
            User result = userService.login(loginForm.bindFromRequest().get());

            if(result != null) {
                session("connected", result.getEmail());
                return ok("Logged in");
            } else {
                return badRequest();
            }

            //TODO return requested body

        } catch (Exception e) {
            return badRequest();
        }
    }

    public Result logout() {
        try {
            session().remove("connected");
            return ok("Logged out");
        } catch (Exception ex) {
            return badRequest("Not logged in");
        }
    }

    public Result currentUser() {
        try {
            return ok(session().get("connected"));

        } catch (Exception ex) {
            return badRequest("User does not exist");
        }
    }

}
