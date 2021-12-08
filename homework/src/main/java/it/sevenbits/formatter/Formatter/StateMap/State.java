package it.sevenbits.formatter.Formatter.StateMap;

import java.util.Objects;

public class State {
    private final String name;

    /**
     * Constructor
     *
     * @param name - state name
     */
    public State(final String name) {
        this.name = name;
    }

    /**
     * This method is returning state's name
     *
     * @return String - current state name
     */
    public String toString() {
        return name;
    }

    /**
     * This method compares two objects
     *
     * @param o - object to compare
     * @return boolean - comparison result
     */
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        State state = (State) o;
        return Objects.equals(name, state.name);
    }

    /**
     * This method is returning hash code
     *
     * @return int - hash code
     */
    public int hashCode() {
        return Objects.hash(name);
    }
}