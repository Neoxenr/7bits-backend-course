package it.sevenbits.fourthworkshop.sm.manager.StateMachine;

import java.util.Objects;

public final class Pair<T, U> {

    private final T first;
    private final U second;

    /**
     *
     * @param first - first pair's element
     * @param second - second pair's element
     */
    public Pair(final T first, final U second) {
        this.first = first;
        this.second = second;
    }

    /**
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
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    /**
     *
     * @return int - hash code
     */
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
