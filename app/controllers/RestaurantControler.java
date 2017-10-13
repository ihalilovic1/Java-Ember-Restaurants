package controllers;

import helpers.RestaurantResponse;
import models.tables.Restaurant;
import models.tables.Review;
import play.db.jpa.Transactional;
import play.mvc.Result;
import services.RestaurantService;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class RestaurantControler extends AbstractController {

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

}
