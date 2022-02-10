package it.sevenbits.fourthpractice.logger.UniqueStorage;

import it.sevenbits.fourthpractice.logger.Planet.Planet;

public interface IUniqueStorage {
    /**
     *
     * @param planet - adding value
     */
    void add(Planet planet);

    /**
     *
     * @param index - number by which will be removing value
     */
    void remove(int index);

    /**
     *
     * @param planet - checking value
     * @return boolean - true if value contains in map
     */
    boolean contains(Planet planet);
}
