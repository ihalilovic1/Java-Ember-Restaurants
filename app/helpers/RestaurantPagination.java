package helpers;

import models.tables.Restaurant;

import java.util.List;

public class RestaurantPagination {
    List<RestaurantResponse> restaurants;
    Long numberOfPages;

    public List<RestaurantResponse> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantResponse> restaurants) {
        this.restaurants = restaurants;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public RestaurantPagination(List<RestaurantResponse> restaurants, Long numberOfPages) {

        this.restaurants = restaurants;
        this.numberOfPages = numberOfPages;
    }

    public RestaurantPagination() {

    }
}
