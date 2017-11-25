package forms;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFilterForm {
    private Integer itemsPerPage;
    private Integer pageNumber;
    private Double priceRange;
    private Double rating;
    private List<String> cuisines;
    private String searchText;
    private String sortBy;

    public RestaurantFilterForm() {
    }

    public RestaurantFilterForm(Integer itemsPerPage, Integer pageNumber, Double priceRange, Double rating, List<String> cuisines, String searchText, String sortBy) {
        this.itemsPerPage = itemsPerPage;
        this.pageNumber = pageNumber;
        this.priceRange = priceRange;
        this.rating = rating;
        this.cuisines = cuisines;
        this.searchText = searchText;
        this.sortBy = sortBy;
    }

    public Double getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Double priceRange) {
        if(priceRange == null) {
            priceRange = 0d;
        }
        this.priceRange = priceRange;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        if(rating == null)
            rating = 0d;
        this.rating = rating;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        if(cuisines == null)
            cuisines = new ArrayList<>();
        this.cuisines = cuisines;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        if(sortBy == null)
            sortBy = "name";
        this.sortBy = sortBy;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        if(itemsPerPage == null)
            itemsPerPage = 6;
        this.itemsPerPage = itemsPerPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        if(pageNumber == null)
            pageNumber = 1;
        this.pageNumber = pageNumber;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        if(searchText == null)
            searchText = "";
        this.searchText = searchText;
    }
}
