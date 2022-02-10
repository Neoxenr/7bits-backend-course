package it.sevenbits.fourthpractice.logger.UniqueStorage;

import it.sevenbits.fourthpractice.logger.Planet.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;

public class UniqueStorage implements IUniqueStorage, Iterable<Planet> {
    private final ArrayList<Planet> planets;

    private final Logger logger = LoggerFactory.getLogger(UniqueStorage.class);

    /**
     * ArrayList initialization
     */
    public UniqueStorage() {
        planets = new ArrayList<>();
    }

    /**
     *
     * @return Iterator<Planet> - iterator on map
     */
    public Iterator<Planet> iterator() {
        return planets.iterator();
    }

    /**
     *
     * @param planet - adding value
     */
    public void add(final Planet planet) {
        if (!contains(planet)) {
            planets.add(planet);
        } else {
            logger.info("The element already exist");
        }
    }

    /**
     *
     * @param index - number by which will be removing value
     */
    public void remove(final int index) {
        if (index < planets.size()) {
            planets.remove(index);
            logger.info("The element with index {} has been removed", index);
        } else {
            logger.error("Out of UniqueStorage range", new ArrayIndexOutOfBoundsException("Out of range"));
        }
    }

    /**
     *
     * @param planet - checking value
     * @return boolean - true if value contains in map
     */
    public boolean contains(final Planet planet) {
        return planets.contains(planet);
    }
}
