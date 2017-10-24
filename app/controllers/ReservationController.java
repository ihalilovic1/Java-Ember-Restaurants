package controllers;

import forms.ReservationForm;
import helpers.ReservationResponse;
import helpers.SessionHelper;
import models.tables.Reservation;
import models.tables.RestaurantTable;
import models.tables.User;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.ReservationService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.UUID;

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
        try {
            Form<ReservationForm> reservationForm = formFactory.form(ReservationForm.class);
            ReservationForm form = reservationForm.bindFromRequest().get();

            if(SessionHelper.isConnected()) {
                User currentUser = new User();
                currentUser.setId(SessionHelper.getId());

                Reservation newReservation = reservationService.makeReservation(form, currentUser);

                return ok(ReservationResponse.makeResponse(newReservation));
            } else {
                return badRequest("Not logged in");
            }
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }


    }

    @Transactional
    public  Result checkReservationAvailability() {
        Form<ReservationForm> reservationForm = formFactory.form(ReservationForm.class);
        ReservationForm form = reservationForm.bindFromRequest().get();

        if(SessionHelper.isConnected()) {
            User currentUser = new User();
            currentUser.setId(SessionHelper.getId());

            return ok();
        } else {
            return badRequest("Not logged in");
        }
    }

}
