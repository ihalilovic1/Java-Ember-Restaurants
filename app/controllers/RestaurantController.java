package controllers;

import forms.MenuForm;
import forms.RestaurantFilterForm;
import forms.RestaurantUUIDForm;
import forms.ReviewForm;
import helpers.MenuResponse;
import helpers.RestaurantLocationResponse;
import helpers.RestaurantResponse;
import helpers.UtilityClass;
import models.tables.Restaurant;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.RestaurantService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.UUID;

public class RestaurantController extends AbstractController {

    private RestaurantService restaurantService;
    private FormFactory formFactory;

    @Inject
    public void setRestaurantService(RestaurantService restaurantService) { this.restaurantService= restaurantService; }

    @Inject
    public void setFormFactory(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    @Transactional
    public Result getRestaurantDetails() {
        try {
            Form<RestaurantUUIDForm> restaurantUUIDForm = formFactory.form(RestaurantUUIDForm.class);
            String uuid = restaurantUUIDForm.bindFromRequest().get().getId();

            Restaurant restaurant = restaurantService.getRestaurantById(UUID.fromString(uuid));
            return ok(RestaurantResponse.makeResponse(restaurant));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result getRestaurantMenu() {
        try {
            Form<MenuForm> menuFormForm = formFactory.form(MenuForm.class);
            MenuForm menuForm = menuFormForm.bindFromRequest().get();

            return ok(MenuResponse.makeResponseList(UtilityClass.filterRestaurantMenu(
                    restaurantService.getRestaurantById(UUID.fromString(menuForm.getIdRestaurant())),menuForm.getType())));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result getRestaurantsLocations() {
        try {
            return ok(RestaurantLocationResponse.makeResponseList(restaurantService.getRestaurantLocations()));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }

    }

    @Transactional
    public  Result insertComment() {
        try {
            Form<ReviewForm> reviewForm = formFactory.form(ReviewForm.class);

            restaurantService.insertComment(reviewForm.bindFromRequest().get());
            return ok();
        } catch (Exception ex) {
            return badRequest();
        }

    }

    @Transactional
    public Result getAllCategories() {
        try {
            return ok(Json.toJson(restaurantService.getAllCategories()));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result allRestaurantsSortReservationsToday() {
        try {
            //TODO sort
            return ok(RestaurantResponse.makeResponseList(restaurantService.getAllRestaurants()));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result getRestaurantsByFilter() {
        try {
            Form<RestaurantFilterForm> restaurantFilterForm = formFactory.form(RestaurantFilterForm.class);
            RestaurantFilterForm form = restaurantFilterForm.bindFromRequest().get();

            //TODO implement other filters
            return ok(RestaurantResponse.makeResponseList(restaurantService
                    .getRestauranByFilter(form.getItemsPerPage(), form.getPageNumber(), 0D, 0, new ArrayList<String>(), "")));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }


    }

}
