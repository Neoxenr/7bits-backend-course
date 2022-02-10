package it.sevenbits.thirdworkshop.User;

import it.sevenbits.thirdworkshop.User.Exceptions.UserManagerException;
import it.sevenbits.thirdworkshop.User.Interfaces.ICollection;

import java.io.IOException;

public class UserManager {
    private final ICollection collection;
    private final String DEFAULT_ROLE = "default";

    /**
     *
     * @param collection - user's collection
     */
    public UserManager(final ICollection collection) {
        this.collection = collection;
    }

    /**
     *
     * @param id - user's id
     * @return User
     * @throws UserManagerException - if user doesn't found
     */
    public User getUserByIndex(final long id) throws UserManagerException {
        try {
            return collection.get(id);
        } catch (IOException e) {
            throw new UserManagerException("Can’t get user by index", e);
        }
    }

    /**
     *
     * @param name - new user's name
     * @throws UserManagerException - if user wasn't added
     */
    public void createDefault(final String name) throws UserManagerException {
        try {
            collection.add(new User(name, DEFAULT_ROLE));
        } catch (IOException e) {
            throw new UserManagerException("Can’t add user to collection", e);
        }
    }
}