package helpers;

import static play.mvc.Controller.session;

public class SessionHelper {

    public static void connect(String id) {
        session("connected", id);
    }

    public static void disconnect() {
        session().remove("connected");
        session().clear();
    }

    public static Integer getId() {
        return Integer.parseInt(session().get("connected"));
    }
}
