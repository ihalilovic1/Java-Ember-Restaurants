package helpers;

import java.util.List;

public class UsersPagination {
    List<UserResponse> users;
    Long numberOfPages;

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public UsersPagination() {

    }

    public UsersPagination(List<UserResponse> users, Long numberOfPages) {

        this.users = users;
        this.numberOfPages = numberOfPages;
    }
}
