package forms;

import java.util.List;

public class RestaurantForm {
    Double longitude;
    Double latitude;
    String restaurantName;
    Double priceRange;
    String location;
    String description;
    String imageFileName;
    String coverFileName;
    List<String> categories;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestaurantForm(Double longitude, Double latitude, String restaurantName, Double priceRange, String location, String description, String imageFileName, String coverFileName, List<String> categories, String id) {

        this.longitude = longitude;
        this.latitude = latitude;
        this.restaurantName = restaurantName;
        this.priceRange = priceRange;
        this.location = location;
        this.description = description;
        this.imageFileName = imageFileName;
        this.coverFileName = coverFileName;
        this.categories = categories;
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Double getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Double priceRange) {
        this.priceRange = priceRange;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public RestaurantForm() {

    }

    public RestaurantForm(Double longitude, Double latitude, String restaurantName, Double priceRange, String location, String description, String imageFileName, String coverFileName, List<String> categories) {

        this.longitude = longitude;
        this.latitude = latitude;
        this.restaurantName = restaurantName;
        this.priceRange = priceRange;
        this.location = location;
        this.description = description;
        this.imageFileName = imageFileName;
        this.coverFileName = coverFileName;
        this.categories = categories;
    }
}
