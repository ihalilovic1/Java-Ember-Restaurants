package helpers;

import java.util.UUID;

import static play.mvc.Controller.session;

public class SessionHelper {

    public static void setToken(String id) {
        removeToken();
        session("connected", id);
    }

    public static void removeToken() {
        session().remove("connected");
        session().clear();
    }

    public static String getToken() {
        return session().get("connected");
    }

    public static Boolean hasToken() {
        return session().containsKey("connected");
    }
}
