package helpers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

public class AdminCountersResponse {
    Long restaurantsNumber;
    Long locationsNumber;
    Long usersNumber;

    public AdminCountersResponse() {
    }

    public AdminCountersResponse(Long restaurantsNumber, Long locationsNumber, Long usersNumber) {
        this.restaurantsNumber = restaurantsNumber;
        this.locationsNumber = locationsNumber;
        this.usersNumber = usersNumber;
    }

    public Long getRestaurantsNumber() {
        return restaurantsNumber;
    }

    public void setRestaurantsNumber(Long restaurantsNumber) {
        this.restaurantsNumber = restaurantsNumber;
    }

    public Long getLocationsNumber() {
        return locationsNumber;
    }

    public void setLocationsNumber(Long locationsNumber) {
        this.locationsNumber = locationsNumber;
    }

    public Long getUsersNumber() {
        return usersNumber;
    }

    public void setUsersNumber(Long usersNumber) {
        this.usersNumber = usersNumber;
    }
}
