package helpers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.tables.RestaurantTable;
import org.h2.table.Table;
import play.libs.Json;

import java.util.List;
import java.util.stream.Collectors;

public class TableResponse {
    String id;
    String idRestaurant;
    Integer sittingPlaces;

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

    public Integer getSittingPlaces() {
        return sittingPlaces;
    }

    public void setSittingPlaces(Integer sittingPlaces) {
        this.sittingPlaces = sittingPlaces;
    }

    public TableResponse() {

    }

    public TableResponse(String id, String idRestaurant, Integer sittingPlaces) {

        this.id = id;
        this.idRestaurant = idRestaurant;
        this.sittingPlaces = sittingPlaces;
    }


    public static ObjectNode makeResponse(RestaurantTable restaurantTable) {
        return (ObjectNode) Json.toJson(new TableResponse(restaurantTable.getId().toString(),
                restaurantTable.getRestaurantId().getId().toString(), restaurantTable.getPersons()));
    }

    public static TableResponse makeResponseObject(RestaurantTable restaurantTable) {
        return new TableResponse(restaurantTable.getId().toString(), restaurantTable.getRestaurantId().getId().toString(),
                restaurantTable.getPersons());
    }

    public static ArrayNode makeResponseList(List<RestaurantTable> listItems) {
        return (ArrayNode) Json.toJson(listItems.stream()
                .map(m -> TableResponse.makeResponseObject(m)).collect(Collectors.toList()));
    }
}
