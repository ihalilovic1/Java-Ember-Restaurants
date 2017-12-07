package forms;

public class LocationForm {
    private String id;
    private String name;
    private String countryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocationForm(String id, String name, String countryName) {

        this.id = id;
        this.name = name;
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public LocationForm(String name, String countryName) {

        this.name = name;
        this.countryName = countryName;
    }

    public LocationForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationForm() {

    }
}
