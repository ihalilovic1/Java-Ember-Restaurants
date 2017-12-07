package services;

import helpers.AdminCountersResponse;
import helpers.CategoryResponse;
import helpers.RestaurantPagination;
import helpers.RestaurantResponse;
import models.tables.*;
import net.sf.ehcache.search.aggregator.Count;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdministratorService extends AbstractService {

    public AdminCountersResponse getCounters() {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<AdminCountersResponse> criteria = criteriaBuilder.createQuery(AdminCountersResponse.class);

   //     Subquery<Long> userCount = criteria.subquery(Long.class);
        Root<User> userRoot = criteria.from(User.class);
     //   userCount.select(criteriaBuilder.count(userRoot.get("id")));

        Subquery<Long> restaurantCount = criteria.subquery(Long.class);
        Root<Restaurant> restaurantRoot = restaurantCount.from(Restaurant.class);
        restaurantCount.select(criteriaBuilder.count(restaurantRoot.get("id")));

        Subquery<Long> locationCount = criteria.subquery(Long.class);
        Root<City> locationRoot = locationCount.from(City.class);
        locationCount.select(criteriaBuilder.count(locationRoot.get("id")));

        criteria.select(criteriaBuilder.construct(
                AdminCountersResponse.class,
                restaurantCount.getSelection(),
                locationCount.getSelection(),
                criteriaBuilder.count(userRoot.get("id"))
        ));

        return entityManager.createQuery(criteria).getSingleResult();
    }

    public Country addCountry(String name) {
        EntityManager entityManager = getEntityManager();

        Country country = new Country(name);

        entityManager.persist(country);

        entityManager.flush();

        return country;
    }

    public City addCity(String name, String countryName) {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Country> criteria = criteriaBuilder.createQuery(Country.class);

        Root<Country> countryRoot = criteria.from(Country.class);

        criteria.select( countryRoot );
        criteria.where(criteriaBuilder.equal(countryRoot.get("name"), countryName));

        Country country = entityManager.createQuery(criteria).getSingleResult();

        if(country == null) {
            throw new IllegalArgumentException("Country not found");
        }

        City city = new City(name, country);

        entityManager.persist(city);

        entityManager.flush();

        return city;
    }

    public Country editCountry(UUID uuid, String newName) {
        EntityManager entityManager = getEntityManager();

        Country country = entityManager.find(Country.class, uuid);

        country.setName(newName);

        entityManager.flush();

        return country;
    }

    public City editCity(UUID uuid, String newName) {
        EntityManager entityManager = getEntityManager();

        City city = entityManager.find(City.class, uuid);

        city.setName(newName);

        entityManager.flush();

        return city;
    }

    public void deleteCity(UUID uuid) {
        try {
            EntityManager entityManager = getEntityManager();

            City city = entityManager.find(City.class, uuid);

            entityManager.remove(city);

            entityManager.flush();
        } catch (PersistenceException ex) {
            throw new IllegalArgumentException("There are resaurants and/or users on this location");
        }
    }

    public void deleteCountry(UUID uuid) {
        try {
            EntityManager entityManager = getEntityManager();

            Country country = entityManager.find(Country.class, uuid);

            entityManager.remove(country);

            entityManager.flush();
        } catch (PersistenceException ex) {
            throw new IllegalArgumentException("There are registered cities in this country");
        }
    }

    public City getCityDetails(UUID uuid) {
        EntityManager entityManager = getEntityManager();

        return entityManager.find(City.class, uuid);
    }

    public Country getCountryDetails(UUID uuid) {
        EntityManager entityManager = getEntityManager();

        return entityManager.find(Country.class, uuid);
    }

    public FoodType addCategory(String name) {

        EntityManager entityManager = getEntityManager();

        FoodType category = new FoodType(name);

        entityManager.persist(category);

        entityManager.flush();

        return category;
    }

    public FoodType editCategory(UUID uuid, String newName) {
        EntityManager entityManager = getEntityManager();

        FoodType foodType = entityManager.find(FoodType.class, uuid);

        foodType.setName(newName);

        entityManager.flush();

        return foodType;
    }

    public void deleteCategory(UUID uuid) {
        try {
            EntityManager entityManager = getEntityManager();

            FoodType foodType = entityManager.find(FoodType.class, uuid);

            entityManager.remove(foodType);

            entityManager.flush();
        } catch (PersistenceException ex) {
            throw new IllegalArgumentException("There are restaurants in this category");
        }
    }

    public FoodType getCategoryDetails(UUID uuid) {
        EntityManager entityManager = getEntityManager();

        return entityManager.find(FoodType.class, uuid);
    }

    public CategoryResponse getFilteredCategories(Integer itemsPerPage,Integer pageNumber, String searchText) {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<FoodType> criteria = criteriaBuilder.createQuery(FoodType.class);

        Root<FoodType> foodTypeRoot = criteria.from(FoodType.class);

        criteria.select(foodTypeRoot);

        criteria.where(criteriaBuilder.like(criteriaBuilder.lower(foodTypeRoot.get("name")), '%' + searchText.toLowerCase() + '%'));

        List<FoodType> categories = entityManager.createQuery(criteria)
                .setFirstResult((pageNumber - 1) * itemsPerPage)
                .setMaxResults(itemsPerPage)
                .getResultList();

        CriteriaQuery<Long> categoryCount = criteriaBuilder.createQuery(Long.class);

        foodTypeRoot = categoryCount.from(FoodType.class);

        categoryCount.select(criteriaBuilder.count(foodTypeRoot));
        categoryCount.where(criteriaBuilder.like(criteriaBuilder.lower(foodTypeRoot.get("name")), '%' + searchText.toLowerCase() + '%'));

        Long count = entityManager.createQuery(categoryCount).getSingleResult();

        if(count != 0)
            count = count / itemsPerPage + 1;

        return new CategoryResponse(categories, count);
    }

    public RestaurantPagination getFilteredRestaurants(Integer itemsPerPage, Integer pageNumber, String searchText) {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<RestaurantResponse> criteria = criteriaBuilder.createQuery(RestaurantResponse.class);

        Root<Restaurant> restaurantRoot = criteria.from(Restaurant.class);

        criteria.select(criteriaBuilder.construct(
                RestaurantResponse.class,
                restaurantRoot
        ));

        criteria.where(criteriaBuilder.like(criteriaBuilder.lower(restaurantRoot.get("name")), '%' + searchText.toLowerCase() + '%'));

        List<RestaurantResponse> categories = entityManager.createQuery(criteria)
                .setFirstResult((pageNumber - 1) * itemsPerPage)
                .setMaxResults(itemsPerPage)
                .getResultList();

        CriteriaQuery<Long> restaurantCount = criteriaBuilder.createQuery(Long.class);

        restaurantRoot = restaurantCount.from(Restaurant.class);

        restaurantCount.select(criteriaBuilder.count(restaurantRoot));
        restaurantCount.where(criteriaBuilder.like(criteriaBuilder.lower(restaurantRoot.get("name")), '%' + searchText.toLowerCase() + '%'));

        Long count = entityManager.createQuery(restaurantCount).getSingleResult();

        if(count != 0)
            count = count / itemsPerPage + 1;

        return new RestaurantPagination(categories, count);
    }
}
