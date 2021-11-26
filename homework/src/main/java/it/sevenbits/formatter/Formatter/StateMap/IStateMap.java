package it.sevenbits.formatter.Formatter.StateMap;

public interface IStateMap<Signal> {
    /**
     * This method is returning default state
     * @return State
     */
    State getStartState();

    /**
     * This method is returning next state for concrete state and signal
     * @param state - input state
     * @param signal - input signal
     * @return State
     */
    State getNextState(State state, Signal signal);
}
