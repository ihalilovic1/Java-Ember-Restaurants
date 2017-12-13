package helpers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.tables.Review;
import play.libs.Json;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewResponse {
    Integer mark;
    String userName;
    String comment;
    String restaurantId;

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public ReviewResponse() {

    }

    public ReviewResponse(Integer mark, String userName, String comment, String restaurantId) {

        this.mark = mark;
        this.userName = userName;
        this.comment = comment;
        this.restaurantId = restaurantId;
    }

    public static ObjectNode makeResponse(Review review) {
        return (ObjectNode) Json.toJson(new ReviewResponse(review.getMark(), review.getUserid().getFirstName(),
                review.getComment(), review.getRestaurant().getId().toString()));
    }

    public static ReviewResponse makeResponseObject(Review review) {
        return new ReviewResponse(review.getMark(), review.getUserid().getFirstName(),
                review.getComment(), review.getRestaurant().getId().toString());
    }

    public static ArrayNode makeResponseList(List<Review> listItems) {
        return (ArrayNode) Json.toJson(listItems.stream()
                .map(m -> ReviewResponse.makeResponseObject(m)).collect(Collectors.toList()));
    }
}
