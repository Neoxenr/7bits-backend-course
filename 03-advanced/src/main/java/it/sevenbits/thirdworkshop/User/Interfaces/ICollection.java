package it.sevenbits.thirdworkshop.User.Interfaces;

import it.sevenbits.thirdworkshop.User.User;

import java.io.IOException;

public interface ICollection {
    /**
     *
     * @param user - new user
     * @throws IOException - if user wasn't added
     */
    void add(User user) throws IOException;

    /**
     *
     * @param index - user's id
     * @return User - user from collection
     * @throws IOException - if user wasn't got
     */
    User get(long index) throws IOException;
}