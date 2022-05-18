package it.sevenbits.eightworkshop.web.model.response.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.sevenbits.eightworkshop.core.model.User;

import java.util.List;

/**
 * Response for get all users
 */
public class AllUsersResponse {


    @JsonProperty("users")
    private List<User> users;

    /**
     * Init response
     *
     * @param users list of users
     */
    public AllUsersResponse(final List<User> users) {
        this.users = users;
    }

    /**
     * Returns list of users
     *
     * @return returns list of users
     */
    public List<User> getUsers() {
        return users;
    }
}
