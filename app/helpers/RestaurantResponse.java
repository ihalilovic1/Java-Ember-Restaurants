package helpers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.tables.Restaurant;
import play.libs.Json;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantResponse {

    String id;
    String restaurantName;
    String description;
    Double latitude;
    Double longitude;
    Integer mark;
    Integer votes;
    Double priceRange;
    String imageFileName;
    String coverFileName;
    String location;
    String foodType;

    public RestaurantResponse() {
    }

    public RestaurantResponse(String id, String restaurantName, String description, Double latitude, Double longitude, Integer mark, Integer votes, Double priceRange, String imageFileName, String coverFileName, String location, String foodType) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mark = mark;
        this.votes = votes;
        this.priceRange = priceRange;
        this.imageFileName = imageFileName;
        this.coverFileName = coverFileName;
        this.location = location;
        this.foodType = foodType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Double getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Double priceRange) {
        this.priceRange = priceRange;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public static ObjectNode makeResponse(Restaurant restaurant) {
        return (ObjectNode) Json.toJson(new RestaurantResponse(restaurant.getId().toString(), restaurant.getName(),
                restaurant.getDescription(), restaurant.getLatitude(), restaurant.getLongitude(), UtilityClass.getMark(restaurant),
                restaurant.getNumberOfVotes(), restaurant.getPriceRange(), restaurant.getImageFileName(),
                restaurant.getCoverFileName(), restaurant.getLocation().getId().toString(), UtilityClass.getFoodTypesAsString(restaurant)));
    }

    public static RestaurantResponse makeResponseObject(Restaurant restaurant) {
        return new RestaurantResponse(restaurant.getId().toString(), restaurant.getName(),
                restaurant.getDescription(), restaurant.getLatitude(), restaurant.getLongitude(), UtilityClass.getMark(restaurant),
                restaurant.getNumberOfVotes(), restaurant.getPriceRange(), restaurant.getImageFileName(),
                restaurant.getCoverFileName(), restaurant.getLocation().getId().toString(), UtilityClass.getFoodTypesAsString(restaurant));
    }

    public static ArrayNode makeResponseList(List<Restaurant> listItems) {
        return (ArrayNode) Json.toJson(listItems.stream()
                .map(m -> RestaurantResponse.makeResponseObject(m)).collect(Collectors.toList()));
    }
}
