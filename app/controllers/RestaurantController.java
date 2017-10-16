package controllers;

import helpers.MenuResponse;
import helpers.RestaurantResponse;
import models.tables.Restaurant;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.RestaurantService;

import javax.inject.Inject;
import java.util.UUID;

public class RestaurantController extends AbstractController {

    private RestaurantService restaurantService;

    @Inject
    public void setRestaurantService(RestaurantService restaurantService) { this.restaurantService= restaurantService; }

    @Transactional
    public Result getRestaurantDetails(String uuid) {
        try {
            Restaurant restaurant = restaurantService.getRestaurantById(UUID.fromString(uuid));
            return ok(RestaurantResponse.makeResponse(restaurant));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result getRestaurantMenu(String uuid, String type) {
        try {
            return ok(MenuResponse.makeResponseList(restaurantService.getRestaurantById(UUID.fromString(uuid)).filterRestaurantMenu(type)));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result getRestaurantsLocations() {
        try {
            return ok(Json.toJson(restaurantService.getRestaurantLocations()));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }

    }
}
