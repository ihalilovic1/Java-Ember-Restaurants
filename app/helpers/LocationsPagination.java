package helpers;

import models.tables.City;

import java.util.List;

public class LocationsPagination {
    List<City> cities;
    Long numberOfPages;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public LocationsPagination() {

    }

    public LocationsPagination(List<City> cities, Long numberOfPages) {

        this.cities = cities;
        this.numberOfPages = numberOfPages;
    }
}
