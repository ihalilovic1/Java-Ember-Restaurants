package models.tables;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table( name = "restauranttables" )
public class RestaurantTable extends AbstractModel {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "restaurantid",
            foreignKey = @ForeignKey(name = "restauranttables_restaurantid_fkey")
    )
    private Restaurant restaurantId;

    @Column(name = "persons")
    private Integer persons;

    public RestaurantTable(Restaurant restaurantId, Integer persons) {
        this.restaurantId = restaurantId;
        this.persons = persons;
    }

    public RestaurantTable() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Restaurant getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurant restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getPersons() {
        return persons;
    }

    public void setPersons(Integer persons) {
        this.persons = persons;
    }
}
