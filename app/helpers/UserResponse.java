package helpers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.tables.User;
import play.libs.Json;

public class UserResponse {
    private String id;
    private String email;
    private String phone;
    private String country;
    private String city;
    private String firstName;
    private String lastName;

    public UserResponse() {
    }

    public UserResponse(String id, String email, String phone, String country, String city, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static ObjectNode makeResponse(User user) {
        return (ObjectNode) Json.toJson(new UserResponse(user.getId().toString(), user.getEmail(), user.getPhone(), user.getCity().getCountry().getName(),
                user.getCity().getName(), user.getFirstName(), user.getLastName()));
    }
}
