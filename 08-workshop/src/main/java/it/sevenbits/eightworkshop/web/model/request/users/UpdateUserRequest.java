package it.sevenbits.eightworkshop.web.model.request.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Update user dto
 */
public class UpdateUserRequest {
    private final String name;

    /**
     * Constructor
     *
     * @param name - new user's updated name
     */
    @JsonCreator
    public UpdateUserRequest(@JsonProperty final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UpdateUserRequest that = (UpdateUserRequest) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
