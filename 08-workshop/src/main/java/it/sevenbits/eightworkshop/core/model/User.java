package it.sevenbits.eightworkshop.core.model;

import java.util.Objects;

/**
 * Model of User
 */
public class User {

    private String id;

    private String name;

    /**
     * Create new User
     *
     * @param id   id of user
     * @param name name of user
     */
    public User(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return returns id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id of user
     */

    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return returns name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name name of user
     */

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

