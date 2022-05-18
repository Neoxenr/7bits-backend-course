package it.sevenbits.eightworkshop.core.repository.users;

import it.sevenbits.eightworkshop.core.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * MapUserRepository
 */
public class MapUserRepository implements IUserRepository {

    private final Map<String, User> users = new ConcurrentHashMap<>();

    /**
     * Create new user
     *
     * @param user new user
     */
    @Override
    public User create(final User user) {
        users.put(user.getId(), user);
        return users.get(user.getId());
    }


    /**
     * Returns tsk by id
     *
     * @param id id user
     * @return returns user
     */
    @Override
    public User getById(final String id) {
        return users.get(id);
    }

    /**
     * Update user by id
     *
     * @param user user with id
     */
    @Override
    public User update(final User user) {
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    /**
     * Remove user by id
     *
     * @param id id user
     */
    @Override
    public User delete(final String id) {
        return users.remove(id);
    }

    /**
     * Returns all users in repository
     *
     * @return returns all users
     */

    @Override
    public List<User> getAll() {
        return users.values().stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }

    /**
     * Returns all users paginated
     *
     * @param page offset user
     * @param size limit user
     * @return returns number of users up to size
     */
    @Override
    public List<User> getAll(final int page, final int size) {
        return users.values().stream()
                .sorted(Comparator.comparing(User::getName))
                .skip(page * size)
                .limit(size)
                .collect(Collectors.toList());
    }

}

