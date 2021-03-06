package models.tables;

import helpers.UtilityClass;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name="restaurants")
public class Restaurant extends AbstractModel{
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> restaurantReviews = new ArrayList<>();

    @Column
    private Double rating;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @OneToMany(mappedBy = "restaurant")
    private List<MenuItem> restaurantMenu = new ArrayList<>();

    @Column(name = "priceRange")
    private Double priceRange;

    public Restaurant(String name, String description, Double latitude, Double longitude, Double priceRange, String imageFileName, String coverFileName, City location, List<FoodType> foodType) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.priceRange = priceRange;
        this.imageFileName = imageFileName;
        this.coverFileName = coverFileName;
        this.location = location;
        this.foodType = foodType;
        this.rating = 0D;
    }

    @Column(name = "imagefilename")
    private String imageFileName;

    @Column(name = "coverFileName")
    private String coverFileName;

    @ManyToOne
    @JoinColumn(name = "location",
            foreignKey = @ForeignKey(name = "restaurants_location_fkey")
    )
    private City location;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "restaurant_foodtype",
            joinColumns = @JoinColumn(name = "restaurant"),
            inverseJoinColumns = @JoinColumn(name = "foodtype"))
    private List<FoodType> foodType = new ArrayList<>();

    public Restaurant() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public City getLocation() {
        return location;
    }

    public void setLocation(City location) {
        this.location = location;
    }

    public List<FoodType> getFoodType() {
        return foodType;
    }

    public void setFoodType(List<FoodType> foodType) {
        this.foodType = foodType;
    }

    public List<Review> getRestaurantReviews() {
        return restaurantReviews;
    }

    public void setRestaurantReviews(List<Review> restaurantReviews) {
        this.restaurantReviews = restaurantReviews;
    }

    public Integer getNumberOfVotes() {
        return getRestaurantReviews().size();
    }

    public List<MenuItem> getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(List<MenuItem> restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }
}
