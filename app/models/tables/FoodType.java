package models.tables;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="foodtypes")
public class FoodType extends AbstractModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    public FoodType() {
    }

    public FoodType(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
