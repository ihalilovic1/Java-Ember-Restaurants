package controllers;

import forms.ReservationForm;
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
        Form<ReservationForm> reservationForm = formFactory.form(ReservationForm.class);
        ReservationForm form = reservationForm.bindFromRequest().get();
        if(SessionHelper.isConnected()) {

            return ok(Json.toJson(form.getPersons()));
        } else {
            return badRequest("Not logged in");
        }

    }

    @Transactional
    public  Result checkReservationAvailability() {
        Form<ReservationForm> reservationForm = formFactory.form(ReservationForm.class);
        ReservationForm form = reservationForm.bindFromRequest().get();

        return ok();
    }

}
