package it.sevenbits.formatter.Formatter.StateMap;

import it.sevenbits.formatter.Formatter.Loader.FormatterStateLoader;
import it.sevenbits.formatter.Formatter.Loader.ILoader;
import it.sevenbits.formatter.Formatter.Token.IToken;

import java.io.IOException;
import java.util.Map;

public class FormatterStateMap implements IStateMap<IToken> {
    private final Map<Pair<State, IToken>, State> states;

    private final State startState = new State("START");

    /**
     * Initializing all states
     */
    public FormatterStateMap() throws IOException {
        ILoader<IToken, State> stateMapLoader = new FormatterStateLoader();
        stateMapLoader.load();

        states = stateMapLoader.get();
    }

    /**
     * This method is returning default state
     *
     * @return State - default state
     */
    public State getStartState() {
        return startState;
    }

    /**
     * This method is returning next state for concrete state and signal
     *
     * @param state  - input state
     * @param signal - input signal
     * @return State
     */
    public State getNextState(final State state, final IToken signal) {
        return states.getOrDefault(new Pair<>(state, signal), startState);
    }
}
