package it.sevenbits.fourthworkshop.sm.manager.StateMachine;

import java.util.Objects;

public class State {
    private final String currentState;

    /**
     *
     * @param currentState - state name
     */
    public State(final String currentState) {
        this.currentState = currentState;
    }

    /**
     *
     * @return String - current state name
     */
    public String toString() {
        return currentState;
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
        State state = (State) o;
        return Objects.equals(currentState, state.currentState);
    }

    /**
     *
     * @return int - hash code
     */
    public int hashCode() {
        return Objects.hash(currentState);
    }
}