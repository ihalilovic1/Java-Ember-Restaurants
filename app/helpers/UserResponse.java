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
    private Boolean isAdmin;

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public UserResponse() {
    }

    public UserResponse(User user) {
        this.id = user.getId().toString();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.country = user.getCity().getCountry().getName();
        this.city = user.getCity().getName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.isAdmin = user.getAdmin();
    }

    public UserResponse(String id, String email, String phone, String country, String city, String firstName, String lastName, Boolean isAdmin) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
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
                user.getCity().getName(), user.getFirstName(), user.getLastName(), user.getAdmin()));
    }
}
