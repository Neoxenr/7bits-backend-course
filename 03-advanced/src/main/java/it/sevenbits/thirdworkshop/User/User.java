package it.sevenbits.thirdworkshop.User;

public class User {
    private final String name;
    private final String role;

    /**
     *
     * @param name - user's name
     * @param role - user's role
     */
    public User(final String name, final String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}