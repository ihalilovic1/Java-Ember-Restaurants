package forms;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.regex.Matcher;

public class FindTablesForm {

    private String persons;
    private String date;
    private String hour;
    private String searchText;

    public FindTablesForm() {
    }

    public Integer getPersons() {
        Matcher m = ReservationForm.personsPattern.matcher(persons);
        m.find();
        return Integer.parseInt(m.group());
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DateTime getDateTime() {

        DateTime dateTime = DateTime.parse(getDate() + " " + getDate(),
                DateTimeFormat.forPattern("MMM dd, yyyy hh:mm a"));

        return  dateTime;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
