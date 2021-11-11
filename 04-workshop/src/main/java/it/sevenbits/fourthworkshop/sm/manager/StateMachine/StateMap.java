package it.sevenbits.fourthworkshop.sm.manager.StateMachine;

import java.util.HashMap;
import java.util.Map;

class StateMap {
    private final State defaultState = new State("IGNORE");

    private final Map<Pair<State, String>, State> states;

    /**
     * Initialization states and transitions between them
     */
    StateMap() {
        states = new HashMap<>();
        State listenState = new State("LISTEN");
        State stubSuspicion = new State("TRASH_SUSPICION");

        // для packagesFillerTaskOne
//        states.put(new Pair<>(defaultState, "MESSAGE"), listenState);
//        states.put(new Pair<>(defaultState, "TRASH"), defaultState);
//
//        states.put(new Pair<>(listenState, "MESSAGE"), listenState);
//        states.put(new Pair<>(listenState, "TRASH"), stubSuspicion);
//
//        states.put(new Pair<>(stubSuspicion, "MESSAGE"), stubSuspicion);
//        states.put(new Pair<>(stubSuspicion, "TRASH"), defaultState);

        // для packagesFillerTaskTwo
        states.put(new Pair<>(defaultState, "MESSAGE_START"), listenState);

        states.put(new Pair<>(listenState, "MESSAGE_FINISH"), defaultState);
        states.put(new Pair<>(listenState, "MESSAGE"), listenState);
        states.put(new Pair<>(listenState, "TRASH"), stubSuspicion);

        states.put(new Pair<>(stubSuspicion, "MESSAGE_FINISH"), defaultState);
        states.put(new Pair<>(stubSuspicion, "MESSAGE"), stubSuspicion);
        states.put(new Pair<>(stubSuspicion, "TRASH"), defaultState);
    }

    /**
     *
     * @return State - start state
     */
    public State getStartState() {
        return defaultState;
    }

    /**
     *
     * @param state - current state
     * @param signal - input signal
     * @return State - next state
     */
    public State getNextState(final State state, final String signal) {
        return states.getOrDefault(new Pair<>(state, signal), defaultState);
    }
}
