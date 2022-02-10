package it.sevenbits.fourthpractice.logger.Planet;

import java.util.UUID;

public class Planet {
    private final String name;
    private final String id;

    /**
     *
     * @param name - planet's name
     */
    public Planet(final String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    /**
     *
     * @return String - planet's name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return String - planet's id
     */
    public String getId() {
        return id;
    }
}
