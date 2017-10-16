package helpers;

import javax.persistence.Entity;
import java.util.UUID;

public class RestaurantLocationResponse {
    private String id;
    private String city;
    private String country;
    private Long number;

    public RestaurantLocationResponse() {
    }

    public RestaurantLocationResponse(String id, String city, String country, Long number) {

        this.id = id;
        this.city = city;
        this.country = country;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public RestaurantLocationResponse(UUID id, String city, String country, Long number) {
        this.id = id.toString();
        this.city = city;
        this.country = country;
        this.number = number;
    }
}
