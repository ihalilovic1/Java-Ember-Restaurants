package services;

import forms.*;
import helpers.*;
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

        List<RestaurantResponse> restaurants = entityManager.createQuery(criteria)
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

        return new RestaurantPagination(restaurants, count);
    }

    public Restaurant addRestaurant(RestaurantForm restaurantForm) {
        EntityManager entityManager = getEntityManager();

        City location = new City();

        location.setId(UUID.fromString(restaurantForm.getLocation()));

        List<FoodType> foodTypes = new ArrayList<FoodType>();

        for(String foodType : restaurantForm.getCategories()) {
            FoodType newCategory = entityManager.find(FoodType.class, UUID.fromString(foodType));
            foodTypes.add(newCategory);
        }

        Restaurant restaurant = new Restaurant(restaurantForm.getRestaurantName(), restaurantForm.getDescription(),
                restaurantForm.getLatitude(), restaurantForm.getLongitude(), restaurantForm.getPriceRange(),
                restaurantForm.getImageFileName(), restaurantForm.getCoverFileName(), location, foodTypes);


        entityManager.persist(restaurant);

        entityManager.flush();

        return restaurant;
    }

    public void deleteRestaurant(UUID uuid) {
        EntityManager entityManager = getEntityManager();

        Restaurant restaurant = entityManager.find(Restaurant.class, uuid);

        entityManager.remove(restaurant);

        entityManager.flush();
    }

    public Restaurant editRestaurant(RestaurantForm restaurantForm) {
        EntityManager entityManager = getEntityManager();

        City location = new City();

        location.setId(UUID.fromString(restaurantForm.getLocation()));

        List<FoodType> foodTypes = new ArrayList<FoodType>();

        for(String foodType : restaurantForm.getCategories()) {
            FoodType newCategory = entityManager.find(FoodType.class, UUID.fromString(foodType));
            foodTypes.add(newCategory);
        }

        Restaurant restaurant = entityManager.find(Restaurant.class, UUID.fromString(restaurantForm.getId()));

        restaurant.setName(restaurantForm.getRestaurantName());
        restaurant.setDescription(restaurantForm.getDescription());
        restaurant.setLatitude(restaurantForm.getLatitude());
        restaurant.setLongitude(restaurantForm.getLongitude());
        restaurant.setPriceRange(restaurantForm.getPriceRange());
        restaurant.setImageFileName(restaurantForm.getImageFileName());
        restaurant.setCoverFileName(restaurantForm.getCoverFileName());
        restaurant.setLocation(location);
        restaurant.setFoodType(foodTypes);

        entityManager.flush();

        return restaurant;
    }

    public List<Review> getAllRestaurantComments(UUID uuid) {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Review> reviewCriteriaQuery = criteriaBuilder.createQuery(Review.class);

        Root<Review> reviewRoot = reviewCriteriaQuery.from(Review.class);

        reviewCriteriaQuery.select(reviewRoot);

        Restaurant restaurant = new Restaurant();
        restaurant.setId(uuid);

        reviewCriteriaQuery.where(criteriaBuilder.equal(reviewRoot.get("restaurant"), restaurant));

        return entityManager.createQuery(reviewCriteriaQuery).getResultList();
    }

    public List<FoodType> getRestaurantCategories(UUID uuid) {
        EntityManager entityManager = getEntityManager();

        Restaurant restaurant = entityManager.find(Restaurant.class, uuid);

        return restaurant.getFoodType();
    }

    public UsersPagination getFilteredUsers(Integer itemsPerPage, Integer pageNumber, String searchText) {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<UserResponse> criteria = criteriaBuilder.createQuery(UserResponse.class);

        Root<User> userRoot = criteria.from(User.class);

        criteria.select(criteriaBuilder.construct(
                UserResponse.class,
                userRoot
        ));

        criteria.where(criteriaBuilder.like(criteriaBuilder.lower(userRoot.get("firstName")), '%' + searchText.toLowerCase() + '%'));

        List<UserResponse> users = entityManager.createQuery(criteria)
                .setFirstResult((pageNumber - 1) * itemsPerPage)
                .setMaxResults(itemsPerPage)
                .getResultList();

        CriteriaQuery<Long> usersCount = criteriaBuilder.createQuery(Long.class);

        userRoot = usersCount.from(User.class);

        usersCount.select(criteriaBuilder.count(userRoot));
        usersCount.where(criteriaBuilder.like(criteriaBuilder.lower(userRoot.get("firstName")), '%' + searchText.toLowerCase() + '%'));

        Long count = entityManager.createQuery(usersCount).getSingleResult();

        if(count != 0 && itemsPerPage != 1)
            count = count / itemsPerPage + 1;

        return new UsersPagination(users, count);
    }

    public List<RestaurantTable> getAllRestaurantTables(UUID uuid) {
        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<RestaurantTable> criteria = cb.createQuery(RestaurantTable.class);

        Root<RestaurantTable> root = criteria.from(RestaurantTable.class);

        criteria.select( root );

        Restaurant restaurant = new Restaurant();
        restaurant.setId(uuid);

        criteria.where(cb.equal(root.get("restaurantId"), restaurant));

        return em.createQuery(criteria).getResultList();
    }

    public void updateTables(TablesUpdateForm tablesUpdateForm) {
        EntityManager entityManager = getEntityManager();

        // Adding tables
        List<TableForm> queue = tablesUpdateForm.getAddQueue();

        for(TableForm table : queue) {
            Restaurant restaurant = new Restaurant();
            restaurant.setId(UUID.fromString(table.getRestaurantId()));

            entityManager.persist(new RestaurantTable(restaurant, table.getSittingPlaces()));
        }

        //Delete tables
        queue = tablesUpdateForm.getDeleteQueue();

        for(TableForm table : queue) {
            RestaurantTable restaurantTable = entityManager.find(RestaurantTable.class, UUID.fromString(table.getId()));

            entityManager.remove(restaurantTable);
        }

        queue = tablesUpdateForm.getEditQueue();
        for(TableForm table : queue) {
            Restaurant restaurant = new Restaurant();
            restaurant.setId(UUID.fromString(table.getRestaurantId()));

            RestaurantTable restaurantTable = entityManager.find(RestaurantTable.class, UUID.fromString(table.getId()));
            restaurantTable.setPersons(table.getSittingPlaces());
            restaurantTable.setRestaurantId(restaurant);
        }

        entityManager.flush();
    }

    public void updateMenus(MenusUpdateForm menusUpdateForm) {
        EntityManager entityManager = getEntityManager();

        // Adding tables
        List<MenuForm> queue = menusUpdateForm.getAddQueue();

        for(MenuForm menuItem : queue) {
            Restaurant restaurant = new Restaurant();
            restaurant.setId(UUID.fromString(menuItem.getIdRestaurant()));

            entityManager.persist(new MenuItem(restaurant, menuItem.getType(), menuItem.getName(),
                    menuItem.getPrice(), menuItem.getDescription()));
        }

        //Delete tables
        queue = menusUpdateForm.getDeleteQueue();

        for(MenuForm menuItem : queue) {
            MenuItem menu = entityManager.find(MenuItem.class, UUID.fromString(menuItem.getId()));

            entityManager.remove(menu);
        }

        queue = menusUpdateForm.getEditQueue();
        for(MenuForm menuItem : queue) {
            Restaurant restaurant = new Restaurant();
            restaurant.setId(UUID.fromString(menuItem.getIdRestaurant()));

            MenuItem menu = entityManager.find(MenuItem.class, UUID.fromString(menuItem.getId()));
            menu.setRestaurant(restaurant);
            menu.setDescription(menuItem.getDescription());
            menu.setName(menuItem.getName());
            menu.setPrice(menuItem.getPrice());
            menu.setType(menuItem.getType());
        }

        entityManager.flush();
    }

    public LocationsPagination getFilteredLocations(Integer itemsPerPage, Integer pageNumber, String searchText) {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<City> criteria = criteriaBuilder.createQuery(City.class);

        Root<City> cityRoot = criteria.from(City.class);

        criteria.select(cityRoot);

        criteria.where(criteriaBuilder.like(criteriaBuilder.lower(cityRoot.get("name")), '%' + searchText.toLowerCase() + '%'));

        List<City> cities = entityManager.createQuery(criteria)
                .setFirstResult((pageNumber - 1) * itemsPerPage)
                .setMaxResults(itemsPerPage)
                .getResultList();

        CriteriaQuery<Long> locationsCount = criteriaBuilder.createQuery(Long.class);

        cityRoot = locationsCount.from(City.class);

        locationsCount.select(criteriaBuilder.count(cityRoot));
        locationsCount.where(criteriaBuilder.like(criteriaBuilder.lower(cityRoot.get("name")), '%' + searchText.toLowerCase() + '%'));

        Long count = entityManager.createQuery(locationsCount).getSingleResult();

        if(count != 0 && itemsPerPage != 1)
            count = count / itemsPerPage + 1;

        return new LocationsPagination(cities, count);
    }
}
