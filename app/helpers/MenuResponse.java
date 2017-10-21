package helpers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.tables.MenuItem;
import play.libs.Json;

import java.util.List;
import java.util.stream.Collectors;

public class MenuResponse {
    private String id;

    private String idRestaurant;

    private String type;

    private String name;

    private Double price;

    private String description;

    public MenuResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MenuResponse(String id, String idRestaurant, String type, String name, Double price, String description) {
        this.id = id;
        this.idRestaurant = idRestaurant;
        this.type = type;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public static ObjectNode makeResponse(MenuItem menuItem) {
        return (ObjectNode) Json.toJson(new MenuResponse(menuItem.getId().toString(),
                menuItem.getRestaurant().getId().toString(), menuItem.getType(), menuItem.getName(), menuItem.getPrice(),
                menuItem.getDescription()));
    }

    public static MenuResponse makeResponseObject(MenuItem menuItem) {
        return new MenuResponse(menuItem.getId().toString(),
                menuItem.getRestaurant().getId().toString(), menuItem.getType(), menuItem.getName(), menuItem.getPrice(),
                menuItem.getDescription());
    }

    public static ArrayNode makeResponseList(List<MenuItem> menuItems) {
        return (ArrayNode) Json.toJson(menuItems.stream()
                                            .map(m -> MenuResponse.makeResponseObject(m)).collect(Collectors.toList()));
    }
}
