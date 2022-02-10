package it.sevenbits.formatter.Formatter.StateMap;

import it.sevenbits.formatter.Formatter.Loader.ILoader;
import it.sevenbits.formatter.Formatter.Loader.LexerStateLoader;

import java.io.IOException;
import java.util.Map;

public class LexerStateMap implements IStateMap<Character> {
    private final Map<Pair<State, Character>, State> states;

    private final State startState = new State("WORD");

    /**
     * Initializing all states
     */
    public LexerStateMap() throws IOException {
        ILoader<Character, State> stateMapLoader = new LexerStateLoader();
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
    public State getNextState(final State state, final Character signal) {
        return states.getOrDefault(new Pair<>(state, signal), state);
    }
}
