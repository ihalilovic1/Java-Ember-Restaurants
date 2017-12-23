package controllers;

import com.google.inject.Inject;
import forms.*;
import helpers.RestaurantResponse;
import helpers.ReviewResponse;
import helpers.TableResponse;
import org.hibernate.exception.ConstraintViolationException;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import services.AdministratorService;

import javax.persistence.PersistenceException;
import java.io.File;
import java.util.UUID;

public class AdministratorController extends AbstractController {

    private AdministratorService administratorService;

    private FormFactory formFactory;

    @javax.inject.Inject
    public void setFormFactory(FormFactory formFactory) {
        this.formFactory = formFactory;
    }


    @Inject
    public void setReservationService(AdministratorService reservationService) {
        this.administratorService = reservationService;
    }

    @Transactional
    public Result getAdminCounters() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            return ok(Json.toJson(administratorService.getCounters()));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result addCountry() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<LocationForm> form = formFactory.form(LocationForm.class);
            LocationForm locationForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.addCountry(locationForm.getCountryName())));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public  Result addCity() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<LocationForm> form = formFactory.form(LocationForm.class);
            LocationForm locationForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.addCity(locationForm.getName(), locationForm.getCountryName())));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result editCountry() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<LocationForm> form = formFactory.form(LocationForm.class);
            LocationForm locationForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.editCountry(UUID.fromString(locationForm.getId()), locationForm.getCountryName())));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result editCity() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<LocationForm> form = formFactory.form(LocationForm.class);
            LocationForm locationForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.editCity(UUID.fromString(locationForm.getId()), locationForm.getName())));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result deleteCity() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<UUIDForm> form = formFactory.form(UUIDForm.class);
            UUIDForm uuidForm = form.bindFromRequest().get();

            administratorService.deleteCity(UUID.fromString(uuidForm.getId()));

            return ok();
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result deleteCountry() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<UUIDForm> form = formFactory.form(UUIDForm.class);
            UUIDForm uuidForm = form.bindFromRequest().get();

            administratorService.deleteCountry(UUID.fromString(uuidForm.getId()));

            return ok();
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result getCityDetails() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<UUIDForm> form = formFactory.form(UUIDForm.class);
            UUIDForm uuidForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.getCityDetails(UUID.fromString(uuidForm.getId()))));
        } catch (Exception ex) {
            return badRequest();
        }
    }

    @Transactional
    public Result getCountryDetails() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<UUIDForm> form = formFactory.form(UUIDForm.class);
            UUIDForm uuidForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.getCountryDetails(UUID.fromString(uuidForm.getId()))));
        } catch (Exception ex) {
            return badRequest();
        }
    }

    @Transactional
    public Result getFilteredCategories() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<PaginationForm> form = formFactory.form(PaginationForm.class);
            PaginationForm paginationForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.getFilteredCategories(
                    paginationForm.getItemsPerPage(),
                    paginationForm.getPageNumber(),
                    paginationForm.getSearchText())));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result addCategory() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<CategoryForm> form = formFactory.form(CategoryForm.class);
            CategoryForm categoryForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.addCategory(categoryForm.getName())));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result editCategory() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<CategoryForm> form = formFactory.form(CategoryForm.class);
            CategoryForm categoryForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.editCategory(UUID.fromString(categoryForm.getId()), categoryForm.getName())));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result deleteCategory() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<CategoryForm> form = formFactory.form(CategoryForm.class);
            CategoryForm categoryForm = form.bindFromRequest().get();

            administratorService.deleteCategory(UUID.fromString(categoryForm.getId()));

            return ok();
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public  Result getCategoryDetails() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<UUIDForm> form = formFactory.form(UUIDForm.class);
            UUIDForm uuidForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.getCategoryDetails(UUID.fromString(uuidForm.getId()))));
        } catch (Exception ex) {
            return badRequest();
        }
    }

    @Transactional
    public Result getFilteredRestaurants() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<PaginationForm> form = formFactory.form(PaginationForm.class);
            PaginationForm paginationForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.getFilteredRestaurants(
                    paginationForm.getItemsPerPage(),
                    paginationForm.getPageNumber(),
                    paginationForm.getSearchText())));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result addRestaurant() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<RestaurantForm> form = formFactory.form(RestaurantForm.class);
            RestaurantForm restaurantForm = form.bindFromRequest().get();

            return ok(RestaurantResponse.makeResponse(administratorService.addRestaurant(restaurantForm)));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result deleteRestaurant() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<UUIDForm> form = formFactory.form(UUIDForm.class);
            UUIDForm uuidForm = form.bindFromRequest().get();

            administratorService.deleteRestaurant(UUID.fromString(uuidForm.getId()));

            return ok();
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result editRestaurant() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<RestaurantForm> form = formFactory.form(RestaurantForm.class);
            RestaurantForm restaurantForm = form.bindFromRequest().get();

            return ok(RestaurantResponse.makeResponse(administratorService.editRestaurant(restaurantForm)));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    public Result uploadPhoto() {
        File file = request().body().asRaw().asFile();
        try {
            return ok(file.getCanonicalPath());
        } catch (Exception ex) {
            return badRequest("Neuspjesan upload");
        }

    }

    @Transactional
    public Result getAllRestaurantComments() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<UUIDForm> form = formFactory.form(UUIDForm.class);
            UUIDForm uuidForm = form.bindFromRequest().get();

            return ok(ReviewResponse.makeResponseList(administratorService.getAllRestaurantComments(UUID.fromString(uuidForm.getId()))));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result getRestaurantCategories() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<UUIDForm> form = formFactory.form(UUIDForm.class);
            UUIDForm uuidForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.getRestaurantCategories(UUID.fromString(uuidForm.getId()))));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }



    @Transactional
    public Result getFilteredUsers() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<PaginationForm> form = formFactory.form(PaginationForm.class);
            PaginationForm paginationForm = form.bindFromRequest().get();

            return ok(Json.toJson(administratorService.getFilteredUsers(
                    paginationForm.getItemsPerPage(),
                    paginationForm.getPageNumber(),
                    paginationForm.getSearchText())));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result getAllRestaurantTables() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<UUIDForm> form = formFactory.form(UUIDForm.class);
            UUIDForm uuidForm = form.bindFromRequest().get();

            return ok(TableResponse.makeResponseList(administratorService.getAllRestaurantTables(UUID.fromString(uuidForm.getId()))));
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result updateTables() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<TablesUpdateForm> form = formFactory.form(TablesUpdateForm.class);
            TablesUpdateForm tablesUpdateForm = form.bindFromRequest().get();

            administratorService.updateTables(tablesUpdateForm);

            return ok();
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }

    @Transactional
    public Result updateMenu() {
        if(!isAdmin())
            return badRequest("Access denied");
        try {
            Form<MenusUpdateForm> form = formFactory.form(MenusUpdateForm.class);
            MenusUpdateForm menusUpdateForm = form.bindFromRequest().get();

            administratorService.updateMenus(menusUpdateForm);

            return ok();
        } catch (Exception ex) {
            return badRequest(ex.getLocalizedMessage());
        }
    }
}
