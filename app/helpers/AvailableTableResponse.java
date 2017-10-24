package helpers;

import models.tables.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class AvailableTableResponse {
    Integer tablesLeft;
    List<String> bestTime = new ArrayList<String>();
    String idRestaurant;
    String restaurantName;
    String restaurantImageFileName;

    public AvailableTableResponse(Integer tablesLeft, List<String> bestTime, String idRestaurant, String restaurantName, String restaurantImageFileName) {
        this.tablesLeft = tablesLeft;
        this.bestTime = bestTime;
        this.idRestaurant = idRestaurant;
        this.restaurantName = restaurantName;
        this.restaurantImageFileName = restaurantImageFileName;
    }

    public AvailableTableResponse(Restaurant restaurant) {
        tablesLeft = 0;
        this.setIdRestaurant(restaurant.getId().toString());
    }

    public AvailableTableResponse() {
    }

    public Integer getTablesLeft() {
        return tablesLeft;
    }

    public void setTablesLeft(Integer tablesLeft) {
        this.tablesLeft = tablesLeft;
    }

    public List<String> getBestTime() {
        return bestTime;
    }

    public void setBestTime(List<String> bestTime) {
        this.bestTime = bestTime;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantImageFileName() {
        return restaurantImageFileName;
    }

    public void setRestaurantImageFileName(String restaurantImageFileName) {
        this.restaurantImageFileName = restaurantImageFileName;
    }
}
