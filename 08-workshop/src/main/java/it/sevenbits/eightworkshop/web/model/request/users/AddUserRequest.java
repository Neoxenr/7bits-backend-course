package it.sevenbits.eightworkshop.web.model.request.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * Create user dto
 */
public class AddUserRequest {
    @NotBlank(message = "Name of the user can't be empty")
    private final String name;

    /**
     * Constructor
     *
     * @param name - new user name
     */
    @JsonCreator
    public AddUserRequest(@JsonProperty("name") final String name) {
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

        AddUserRequest that = (AddUserRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
