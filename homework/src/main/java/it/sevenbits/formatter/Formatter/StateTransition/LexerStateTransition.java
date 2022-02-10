package it.sevenbits.formatter.Formatter.StateTransition;

import it.sevenbits.formatter.Formatter.StateMap.LexerStateMap;
import it.sevenbits.formatter.Formatter.StateMap.State;

public class LexerStateTransition implements IStateTransition<Character> {
    private final LexerStateMap lexerStateMap;

    /**
     * Initializing fields
     */
    public LexerStateTransition() {
        lexerStateMap = new LexerStateMap();
    }

    /**
     * This method is returning default state
     * @return State
     */
    public State getStartState() {
        return lexerStateMap.getStartState();
    }

    /**
     * This method is returning next state
     * @param state - input state
     * @param signal - input signal
     * @return State
     */
    public State getNextState(final State state, final Character signal) {
        return lexerStateMap.getNextState(state, signal);
    }
}
