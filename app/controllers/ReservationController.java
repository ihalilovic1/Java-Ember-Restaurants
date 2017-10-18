package controllers;

import helpers.SessionHelper;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.ReservationService;

import javax.inject.Inject;

public class ReservationController extends AbstractController {

    private ReservationService reservationService;
    private FormFactory formFactory;

    @Inject
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Inject
    public void setFormFactory(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    @Transactional
    public Result makeReservation() {
        if(SessionHelper.isConnected()) {
            Form<ReservationForm> reservationForm = formFactory.form(ReservationForm.class);

            return ok(Json.toJson(reservationForm.bindFromRequest().get().getPersons()));
        } else {
            return badRequest("Not logged in");
        }

    }
}
