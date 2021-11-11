package it.sevenbits.fourthworkshop.sm.manager.StateMachine;

import it.sevenbits.fourthworkshop.sm.network.NetworkPackage;

public final class StateTransition {
    private final StateMap stateMap;

    /**
     * State map initialization
     */
    public StateTransition() {
        this.stateMap = new StateMap();
    }

    /**
     *
     * @param state - current state
     * @param p - network package
     * @return State - next state
     */
    public State nextState(final State state, final NetworkPackage p) {
        return stateMap.getNextState(state, p.getType());
    }

    /**
     *
     * @return State - start state
     */
    public State getStartState() {
        return this.stateMap.getStartState();
    }
}
