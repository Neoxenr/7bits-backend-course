package it.sevenbits.formatter.Formatter.StateMap;

import java.util.Objects;

public class Pair<U, T> {
    private final U first;
    private final T second;

    /**
     * Initializing all fields
     *
     * @param first  - pair's first value
     * @param second - pair's second value
     */
    public Pair(final U first, final T second) {
        this.first = first;
        this.second = second;
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
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return first.equals(pair.first) && second.equals(pair.second);
    }

    /**
     * This method calculates hash code
     *
     * @return int - hash code
     */
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
