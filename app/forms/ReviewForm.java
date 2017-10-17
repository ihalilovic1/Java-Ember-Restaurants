package forms;

public class ReviewForm {
    private Integer mark;
    private String idUser;
    private String idRestaurant;
    private String comment;

    public ReviewForm() {}

    public ReviewForm(Integer mark, String idUser, String idRestaurant, String comment) {
        this.mark = mark;
        this.idUser = idUser;
        this.idRestaurant = idRestaurant;
        this.comment = comment;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
