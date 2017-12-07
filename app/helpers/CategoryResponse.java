package helpers;

import models.tables.FoodType;

import java.util.ArrayList;
import java.util.List;

public class CategoryResponse {
    List<FoodType> categories;
    Long numberOfPages;

    public List<FoodType> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<FoodType> categories) {
        this.categories = categories;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public CategoryResponse(List<FoodType> categories, Long numberOfPages) {

        this.categories = categories;
        this.numberOfPages = numberOfPages;
    }

    public CategoryResponse() {

    }
}
