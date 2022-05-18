package it.sevenbits.eightworkshop.web.service.users;


import it.sevenbits.eightworkshop.core.model.User;
import it.sevenbits.eightworkshop.core.repository.users.IUserRepository;

import java.util.List;
import java.util.UUID;

/**
 * Service for user user resource
 */
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    /**
     * Create service
     *
     * @param userRepository repository of users
     */
    public UserService(final IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Returns all users
     *
     * @return returns users
     */
    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getById(final String id) {
        return userRepository.getById(id);
    }

    /**
     * Create new user
     *
     * @param name name of user
     * @return new user
     */
    @Override
    public User create(final String name) {
        String id = UUID.randomUUID().toString();
        User user = new User(id, name);

        return userRepository.create(user);
    }

    @Override
    public User update(final String id, final String name) {
        return userRepository.update(new User(id, name));
    }

    @Override
    public User delete(final String id) {
        return userRepository.delete(id);
    }
}

