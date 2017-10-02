package controllers;

import models.tables.User;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.UserService;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static play.mvc.Results.ok;

public class UserController {

    private UserService userService;

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /*
    ObjectNode result = Json.newObject();
        result.put("response", "testiramo ajax");
        return ok(result);
     */

    @Transactional
    public Result getMe() {

        User result = userService.getUser();

        return ok( result.getFirstName() + " " + result.getLastName());
    }

}
