package controllers;

import forms.LoginForm;
import forms.RegisterForm;
import helpers.SessionHelper;
import helpers.UserResponse;
import models.tables.User;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.UserService;

import javax.inject.Inject;

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
        try {
            Form<RegisterForm> registerForm = formFactory.form(RegisterForm.class);

            User result = userService.register(registerForm.bindFromRequest().get());

            setToken(result);
            return ok(UserResponse.makeResponse(result));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }

    }

    @Transactional
    public Result login() {
        try {
            Form<LoginForm> loginForm = formFactory.form(LoginForm.class);

            User result = userService.login(loginForm.bindFromRequest().get());

            if(result != null) {
                setToken(result);
                return ok(UserResponse.makeResponse(result));
            } else {
                return badRequest(Json.parse("{\"error\":\"Entered data is not valid!\"}"));
        }

        } catch (Exception e) {
            return badRequest(e.getLocalizedMessage());
        }
    }

    @Transactional
    public Result logout() {
        try {
            removeToken();
            return ok();
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result currentUser() {
        try {
            User result = getCurrentUser();

            if(result != null) {
                return ok(UserResponse.makeResponse(result));
            } else {
                return badRequest(Json.toJson("User does not exist"));
            }
        } catch (Exception ex) {
            return badRequest(Json.toJson("User does not exist"));
        }
    }

}
