package it.sevenbits.formatter.Formatter.StateTransition;

import it.sevenbits.formatter.Formatter.StateMap.FormatterStateMap;
import it.sevenbits.formatter.Formatter.StateMap.State;
import it.sevenbits.formatter.Formatter.Token.IToken;

import java.io.IOException;

public class FormatterStateTransition implements IStateTransition<IToken> {
    private final FormatterStateMap formatterStateMap;

    /**
     * Initializing fields
     */
    public FormatterStateTransition() throws IOException {
        formatterStateMap = new FormatterStateMap();
    }

    /**
     * This method is returning default state
     *
     * @return State
     */
    public State getStartState() {
        return formatterStateMap.getStartState();
    }

    /**
     * This method is returning next state
     *
     * @param state  - input state
     * @param signal - input signal
     * @return State
     */
    public State getNextState(final State state, final IToken signal) {
        return formatterStateMap.getNextState(state, signal);
    }
}
