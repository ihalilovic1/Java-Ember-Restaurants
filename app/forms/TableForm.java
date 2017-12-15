package forms;

public class TableForm {
    Integer sittingPlaces;
    String restaurantId;
    String id;

    public Integer getSittingPlaces() {
        return sittingPlaces;
    }

    public void setSittingPlaces(Integer sittingPlaces) {
        this.sittingPlaces = sittingPlaces;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TableForm() {

    }

    public TableForm(Integer sittingPlaces, String restaurantId, String id) {

        this.sittingPlaces = sittingPlaces;
        this.restaurantId = restaurantId;
        this.id = id;
    }
}
