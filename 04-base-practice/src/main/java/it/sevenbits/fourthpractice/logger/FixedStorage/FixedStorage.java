package it.sevenbits.fourthpractice.logger.FixedStorage;

import it.sevenbits.fourthpractice.logger.Planet.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.TreeMap;

public class FixedStorage implements IFixedStorage, Iterable<Planet> {
    private final TreeMap<String, Planet> planets;

    private final Logger logger = LoggerFactory.getLogger(FixedStorage.class);

    private final int size;

    /**
     *
     * @return Iterator<Planet> - iterator on map
     */
    public Iterator<Planet> iterator() {
        return planets.values().iterator();
    }

    /**
     *
     * @param size - map size
     */
    public FixedStorage(final int size) {
        this.planets = new TreeMap<>();
        this.size = size;
    }

    /**
     *
     * @param key - keyword by which will be adding value
     * @param planet - adding value
     */
    public void add(final String key, final Planet planet) {
        if (planets.size() < size) {
            if (contains(planet)) {
                logger.info("The element with this key already exist");
            }
            planets.put(key, planet);
            logger.info("The element with key \"" + key + "\" has been added");
        } else {
            logger.error("The element with key \"" + key + "\" hasn't been added",
                    new IndexOutOfBoundsException("Out of range"));
        }
    }

    /**
     *
     * @param key - keyword by which will be removing value
     */
    public void remove(final String key) {
        if (contains(get(key))) {
            planets.remove(key);
            logger.info("The element with key \"" + key + "\" has been removed");
        } else {
            logger.error("The element with key \"" + key + "\" does not exist", new IndexOutOfBoundsException("Out of range"));
        }
    }

    /**
     *
     * @param key - keyword by which will be getting value
     * @return Planet - value from map
     */
    public Planet get(final String key) {
        if (contains(planets.get(key))) {
            logger.info("The element with key \"" + key + "\" has been received");
            return planets.get(key);
        } else {
            logger.error("The element with key \"" + key + "\" does not exist", new IndexOutOfBoundsException("Out of range"));
        }
        return null;
    }

    /**
     *
     * @param planet - checking value
     * @return boolean - true if value contains in map
     */
    public boolean contains(final Planet planet) {
        return planets.containsValue(planet);
    }
}
