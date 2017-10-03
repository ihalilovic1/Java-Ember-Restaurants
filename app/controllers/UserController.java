package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import forms.LoginForm;
import forms.RegisterForm;
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

        return badRequest("Not implemented");
    }

    @Transactional
    public Result login() {
        try {
            Form<LoginForm> loginForm = formFactory.form(LoginForm.class);
            if(loginForm.hasErrors()) {
                return badRequest(loginForm.errorsAsJson());
            }
            User result = userService.login(loginForm.bindFromRequest().get());

            if(result != null) {
                session("connected", result.getId().toString());
                ObjectNode json = (ObjectNode)Json.toJson(result);
                json.remove("password");
                json.put("country", result.getCity().getCountry().getName());
                json.put("city", result.getCity().getName());
                return ok(json);
            } else {
                return badRequest(Json.parse("{\"error\":\"Entered data is not valid!\"}"));
        }

            //TODO return requested body

        } catch (Exception e) {
            return badRequest();
        }
    }

    @Transactional
    public Result logout() {
        try {
            session().remove("connected");
            return ok();
        } catch (Exception ex) {
            return badRequest();
        }
    }

    @Transactional
    public Result currentUser() {
        try {
            User result = userService.getUserById(Integer.parseInt(session().get("connected")));

            if(result != null) {
                //TODO return according to api table, currently returning password
                ObjectNode json = (ObjectNode)Json.toJson(result);
                json.remove("password");
                json.put("country", result.getCity().getCountry().getName());
                json.put("city", result.getCity().getName());
                return ok(json);
            } else {
                return badRequest(Json.toJson("User does not exist"));
            }
        } catch (Exception ex) {
            return badRequest(Json.toJson("User does not exist"));
        }
    }

}
