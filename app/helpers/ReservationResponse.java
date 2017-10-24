package helpers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.tables.Reservation;
import play.libs.Json;

public class ReservationResponse {
    private String id;
    private String idTable;
    private String idUser;
    private Integer persons;
    private Long reservationDateTime;


    public ReservationResponse() {
    }

    public ReservationResponse(String id, String idTable, String idUser, Integer persons, Long reservationDateTime) {
        this.id = id;
        this.idTable = idTable;
        this.idUser = idUser;
        this.persons = persons;
        this.reservationDateTime = reservationDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Integer getPersons() {
        return persons;
    }

    public void setPersons(Integer persons) {
        this.persons = persons;
    }

    public Long getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(Long reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    public static ObjectNode makeResponse(Reservation reservation) {
        return (ObjectNode) Json.toJson(new ReservationResponse(reservation.getId().toString(), reservation.getIdTable().getId().toString(),
                                        reservation.getIdUser().getId().toString(), reservation.getIdTable().getPersons(),
                                        reservation.getReservationTime().getTime()));
    }

}
