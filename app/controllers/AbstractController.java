package controllers;

import helpers.SessionHelper;
import models.tables.User;
import play.data.FormFactory;
import play.mvc.Controller;
import services.AuthService;

import javax.inject.Inject;

public abstract class AbstractController extends Controller {

    private AuthService authService;

    @Inject
    public void setAuthService(AuthService authService) { this.authService = authService; }

    public AbstractController() {
    }

    public Boolean isLoggedIn() {
        if(SessionHelper.hasToken()) {
            return authService.authenticate(SessionHelper.getToken()) != null;
        } else {
            return false;
        }
    }

    public void setToken(User user) {
        removeToken();
        SessionHelper.setToken(authService.setToken(user));
    }

    public void removeToken() {
        SessionHelper.removeToken();
    }

    public User getCurrentUser() {
        if(SessionHelper.hasToken()) {
            return authService.authenticate(SessionHelper.getToken());
        } else {
            return null;
        }
    }

    public Boolean isAdmin() {
        User currentUser = getCurrentUser();

        if(currentUser != null) {
            return currentUser.getAdmin();
        } else {
            return false;
        }
    }
}
