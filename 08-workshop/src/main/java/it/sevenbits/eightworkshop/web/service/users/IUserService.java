package it.sevenbits.eightworkshop.web.service.users;

import it.sevenbits.eightworkshop.core.model.User;

import java.util.List;

/**
 * Service witch work with users
 */
public interface IUserService {

    /**
     * Returns all users
     *
     * @return returns users
     */
    List<User> getAll();

    /**
     * Returns user by id
     *
     * @param id - user's id
     * @return user by id
     */
    User getById(String id);

    /**
     * Create new user
     *
     * @param name name of user
     * @return new user
     */
    User create(String name);

    /**
     * Update user
     *
     * @param id - user's id
     * @param name - new user's name
     * @return updated user
     */
    User update(String id, String name);

    /**
     * Delete user by id
     * @param id - user's id
     * @return deleted user
     */
    User delete(String id);
}

