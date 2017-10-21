package forms;

public class MenuForm {
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

    public MenuForm() {

    }

    public MenuForm(String idRestaurant, String type) {

        this.idRestaurant = idRestaurant;
        this.type = type;
    }
}
