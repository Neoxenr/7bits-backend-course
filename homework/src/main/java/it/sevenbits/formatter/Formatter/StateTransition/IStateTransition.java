package it.sevenbits.formatter.Formatter.StateTransition;

import it.sevenbits.formatter.Formatter.StateMap.State;

public interface IStateTransition<Signal> {
    /**
     * This method is returning default state
     *
     * @return State
     */
    State getStartState();

    /**
     * This method is returning next state
     *
     * @param state  - input state
     * @param signal - input signal
     * @return State
     */
    State getNextState(State state, Signal signal);
}
