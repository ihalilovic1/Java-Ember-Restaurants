package forms;

public class RestaurantFilterForm {
    private String searchText;

    public RestaurantFilterForm(String searchText) {
        this.searchText = searchText;
    }

    public RestaurantFilterForm() {
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
