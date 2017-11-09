package forms;

public class RestaurantFilterForm {
    private Integer itemsPerPage;
    private Integer pageNumber;
    private String searchText;

    public RestaurantFilterForm() {
    }

    public RestaurantFilterForm(Integer itemsPerPage, Integer pageNumber, String searchText) {
        this.itemsPerPage = itemsPerPage;
        this.pageNumber = pageNumber;
        this.searchText = searchText;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
