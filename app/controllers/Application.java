package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.*;
import play.libs.Json;
import play.mvc.*;

public class Application extends Controller {

    public Result test() {
        ObjectNode result = Json.newObject();
        result.put("response", "testiramo ajax");
        return ok(result);
    }

}
