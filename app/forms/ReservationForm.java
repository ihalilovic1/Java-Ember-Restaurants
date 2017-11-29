package forms;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReservationForm {
    private String persons;
    private String reservationDate;
    private String reservationHour;
    private String idRestaurant;

    public static final Pattern personsPattern = Pattern.compile("(\\d+)");

    public ReservationForm(String persons, String reservationDate, String reservationHour, String idRestaurant) {
        this.persons = persons;
        this.reservationDate = reservationDate;
        this.reservationHour = reservationHour;
        this.idRestaurant = idRestaurant;
    }

    public ReservationForm() {
    }

    public Integer getPersons() {
        Matcher m = personsPattern.matcher(persons);
        m.find();
        return Integer.parseInt(m.group());
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public String getTimestampString() {
        String newDate = reservationDate;
        newDate.replace(' ', '-');
        newDate.replace(",", "");
        return newDate + ' ' + getReservationHour();
    }

    public DateTime getDateTime() {

        DateTime dateTime = DateTime.parse(getReservationDate() + " " + getReservationHour(),
                                            DateTimeFormat.forPattern("MMM dd, yyyy hh:mm a"));

        return  dateTime;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationHour() {
        return reservationHour;
    }

    public void setReservationHour(String reservationHour) {
        this.reservationHour = reservationHour;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }
}
