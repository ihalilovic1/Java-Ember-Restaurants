package forms;

public class MenuForm {
    String id;

    public MenuForm(String id, String name, String description, Double price, String idRestaurant, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.idRestaurant = idRestaurant;
        this.type = type;
    }

    String name;
    String description;
    Double price;
    String idRestaurant;
    String type;

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MenuForm() {

    }

    public MenuForm(String idRestaurant, String type) {

        this.idRestaurant = idRestaurant;
        this.type = type;
    }
}
