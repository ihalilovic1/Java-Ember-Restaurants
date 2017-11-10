package helpers;

import models.tables.MenuItem;
import models.tables.Restaurant;
import org.joda.time.DateTime;

import java.util.List;
import java.util.stream.Collectors;

public class UtilityClass {

    public static Integer getMark(Restaurant restaurant) {
        Integer numberOfVotes = restaurant.getNumberOfVotes();
        if(numberOfVotes == 0) {
            return 0;
        } else {
            return restaurant.getRestaurantReviews().stream()
                    .mapToInt(r -> r.getMark())
                    .sum()/numberOfVotes;
        }
    }

    public static String getFoodTypesAsString(Restaurant restaurant) {
        return restaurant.getFoodType().stream()
                .map(f -> f.getName())
                .collect (Collectors.joining (" | "));
    }

    public static List<MenuItem> filterRestaurantMenu(Restaurant restaurant, String type) {
        return restaurant.getRestaurantMenu().stream()
                .filter(m -> m.getType().equals(type))
                .collect(Collectors.toList());
    }
}
