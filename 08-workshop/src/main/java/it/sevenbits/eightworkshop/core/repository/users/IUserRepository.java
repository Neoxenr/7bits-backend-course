package it.sevenbits.eightworkshop.core.repository.users;

import it.sevenbits.eightworkshop.core.model.User;

import java.util.List;

/**
 * Interface for repository of users
 */
public interface IUserRepository {

    /**
     * Returns user by id
     *
     * @param id id user
     * @return returns user
     */
    User getById(String id);

    /**
     * Create new user
     *
     * @param user new user
     * @return created user
     */
    User create(User user);

    /**
     * Returns all users in repository (not safe!)
     *
     * @return returns all users
     */
    List<User> getAll();

    /**
     * Returns all users paginated
     *
     * @param page offset user
     * @param size limit user
     * @return returns number of users up to size
     */
    List<User> getAll(int page, int size);

    /**
     * Update user by id
     *
     * @param user user with id
     * @return returns count updated rows
     */
    User update(User user);

    /**
     * Remove user by id
     *
     * @param id id user
     * @return returns count deleted rows
     */
    User delete(String id);
}

