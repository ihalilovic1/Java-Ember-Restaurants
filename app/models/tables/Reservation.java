package models.tables;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table( name = "reservations" )
public class Reservation extends AbstractModel {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idtable",
            foreignKey = @ForeignKey(name = "reservations_idtable_fkey")
    )
    private RestaurantTable idTable;

    @ManyToOne
    @JoinColumn(name = "iduser",
            foreignKey = @ForeignKey(name = "reservations_iduser_fkey")
    )
    private User idUser;

    @Column(name = "reservationtime")
    private Timestamp reservationTime;

    @Column(name = "timeadded")
    private Timestamp timeAdded;

    @Column(name = "isconfirmed")
    private Boolean isConfirmed;

    public Reservation(RestaurantTable idTable, User idUser, Timestamp reservationTime, Timestamp timeAdded, Boolean isConfirmed) {
        this.idTable = idTable;
        this.idUser = idUser;
        this.reservationTime = reservationTime;
        this.timeAdded = timeAdded;
        this.isConfirmed = isConfirmed;
    }

    public Reservation() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RestaurantTable getIdTable() {
        return idTable;
    }

    public void setIdTable(RestaurantTable idTable) {
        this.idTable = idTable;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Timestamp reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Timestamp getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Timestamp timeAdded) {
        this.timeAdded = timeAdded;
    }

    public Boolean getConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        isConfirmed = confirmed;
    }
}
