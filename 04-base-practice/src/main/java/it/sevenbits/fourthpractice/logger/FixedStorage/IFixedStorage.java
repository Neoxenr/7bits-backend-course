package it.sevenbits.fourthpractice.logger.FixedStorage;

import it.sevenbits.fourthpractice.logger.Planet.Planet;

public interface IFixedStorage {
    /**
     *
     * @param key - keyword by which will be adding value
     * @param planet - adding value
     */
    void add(String key, Planet planet);

    /**
     *
     * @param key - keyword by which will be removing value
     */
    void remove(String key);

    /**
     *
     * @param key - keyword by which will be getting value
     * @return Planet - value from map
     */
    Planet get(String key);

    /**
     *
     * @param planet - checking value
     * @return boolean - true if value contains in map
     */
    boolean contains(Planet planet);
}
