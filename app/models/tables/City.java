package models.tables;


import javax.persistence.*;

@Entity
@Table( name = "\"cities\"" )
public class City {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country",
            foreignKey = @ForeignKey(name = "cities_country_fkey")
    )
    private Country country;

    public City() {
    }

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
