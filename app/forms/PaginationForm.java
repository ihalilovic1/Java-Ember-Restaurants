package forms;

public class PaginationForm {
    Integer itemsPerPage;
    Integer pageNumber;
    String searchText;

    public PaginationForm() {
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
        if(searchText == null)
            this.searchText = "";
        else
            this.searchText = searchText;
    }

    public PaginationForm(Integer itemsPerPage, Integer pageNumber, String searchText) {

        this.itemsPerPage = itemsPerPage;
        this.pageNumber = pageNumber;
        this.searchText = searchText;
    }

    public PaginationForm(Integer itemsPerPage, Integer pageNumber) {

        this.itemsPerPage = itemsPerPage;
        this.pageNumber = pageNumber;
    }
}
