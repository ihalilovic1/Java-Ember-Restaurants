package controllers;

import forms.ReservationForm;
import forms.RestaurantUUIDForm;
import helpers.AvailableTableResponse;
import helpers.ErrorResponse;
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
    public Result confirmReservation() {
        try {
            Form<RestaurantUUIDForm> reservationUUIDForm = formFactory.form(RestaurantUUIDForm.class);
            UUID id = UUID.fromString(reservationUUIDForm.bindFromRequest().get().getId());

            return ok(Json.toJson(reservationService.confirmReservation(id)));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public  Result checkReservationAvailability() {
        try {
            Form<ReservationForm> reservationForm = formFactory.form(ReservationForm.class);
            ReservationForm form = reservationForm.bindFromRequest().get();

            if(SessionHelper.isConnected()) {
                User currentUser = new User();
                currentUser.setId(SessionHelper.getId());
                AvailableTableResponse availableTables = reservationService.checkReservationAvailability(form ,currentUser);
                if(availableTables.getTablesLeft() == 0) {
                    return badRequest(Json.toJson(ErrorResponse.error("No available tables!")));
                }
                return ok(Json.toJson(availableTables));
            } else {
                return badRequest("Not logged in");
            }
        } catch (Exception ex) {
            return badRequest();
        }

    }

    @Transactional
    public Result getReservation() {
        try {
            Form<RestaurantUUIDForm> reservationUUIDForm = formFactory.form(RestaurantUUIDForm.class);
            UUID id = UUID.fromString(reservationUUIDForm.bindFromRequest().get().getId());

            return ok(ReservationResponse.makeResponse(reservationService.getReservation(id)));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }

    }

}
