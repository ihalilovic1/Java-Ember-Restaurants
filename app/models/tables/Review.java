package models.tables;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="reviews")
public class Review extends AbstractModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "mark")
    private Integer mark;

    @ManyToOne
    @JoinColumn(name = "userid",
            foreignKey = @ForeignKey(name = "reviews_userid_fkey")
    )
    private User userid;

    @ManyToOne
    @JoinColumn(name = "restaurant",
            foreignKey = @ForeignKey(name = "reviews_restaurant_fkey")
    )
    private Restaurant restaurant;

    @Column(name = "comment")
    private String comment;

    public Review() {
    }

    public Review(Integer mark, User userid, Restaurant restaurant, String comment) {
        this.mark = mark;
        this.userid = userid;
        this.restaurant = restaurant;
        this.comment = comment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
