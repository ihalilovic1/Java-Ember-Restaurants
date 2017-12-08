package controllers;

import forms.FindTablesForm;
import forms.ReservationForm;
import forms.UUIDForm;
import helpers.*;
import models.tables.Reservation;
import models.tables.User;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.ReservationService;

import javax.inject.Inject;
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

            Reservation newReservation = reservationService.makeReservation(form);

            return ok(ReservationResponse.makeResponse(newReservation));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }

    }

    @Transactional
    public Result confirmReservation() {
        try {
            Form<UUIDForm> reservationUUIDForm = formFactory.form(UUIDForm.class);
            UUID id = UUID.fromString(reservationUUIDForm.bindFromRequest().get().getId());

            if(isLoggedIn()) {
                User currentUser = new User();
                currentUser.setId(getCurrentUser().getId());

                return ok(Json.toJson(reservationService.confirmReservation(id, currentUser)));
            } else {
                return badRequest("Not logged in");
            }

        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public  Result checkReservationAvailability() {
        try {
            Form<ReservationForm> reservationForm = formFactory.form(ReservationForm.class);
            ReservationForm form = reservationForm.bindFromRequest().get();

            AvailableTableResponse availableTables = reservationService.checkReservationAvailability(form);

            if(availableTables.getTablesLeft() == 0) {
                return badRequest(Json.toJson(ErrorResponse.error("No available tables!")));
            }
            return ok(Json.toJson(availableTables));

        } catch (Exception ex) {
            return badRequest();
        }

    }

    @Transactional
    public Result getReservation() {
        try {
            Form<UUIDForm> reservationUUIDForm = formFactory.form(UUIDForm.class);
            UUID id = UUID.fromString(reservationUUIDForm.bindFromRequest().get().getId());

            return ok(ReservationResponse.makeResponse(reservationService.getReservation(id)));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result getFreeTables() {
        try {
            Form<FindTablesForm> tablesFormForm = formFactory.form(FindTablesForm.class);
            FindTablesForm form = tablesFormForm.bindFromRequest().get();

            return ok(RestaurantResponse.makeResponseList(reservationService.getFreeTables(form)));
        } catch (Exception ex) {
            return badRequest();
        }
    }

}
