package controllers;

import play.mvc.Result;

import static play.mvc.Results.ok;

public class UserController {

    /*
    ObjectNode result = Json.newObject();
        result.put("response", "testiramo ajax");
        return ok(result);
     */

    public Result register() {
        return ok("Registrovan novi user");
    }

}
