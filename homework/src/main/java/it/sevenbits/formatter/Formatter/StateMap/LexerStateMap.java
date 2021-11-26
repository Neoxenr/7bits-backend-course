package it.sevenbits.formatter.Formatter.StateMap;

import java.util.HashMap;
import java.util.Map;

public class LexerStateMap implements IStateMap<Character> {
    private final Map<Pair<State, Character>, State> states;

    private final State startState;

    /**
     * Initializing all states
     */
    public LexerStateMap() {
        states = new HashMap<>();

        startState = new State("WORD");

        State finishState = new State("WORD_FINISH");
        State figureBracketState = new State("FIGURE_BRACKET_FINISH");
        State squareBracketState = new State("SQUARE_BRACKET_FINISH");
        State roundBracketState = new State("ROUND_BRACKET_FINISH");
        State commaState = new State("COMMA_FINISH");
        State pointState = new State("POINT_FINISH");
        State semiColonState = new State("SEMICOLON_FINISH");
        State stringLiteralState = new State("STRING_LITERAL");
        State stringLiteralFinishState = new State("STRING_LITERAL_FINISH");
        State divisionState = new State("DIVISION");
        State divisionStateFinish = new State("DIVISION_FINISH");
        State oneStringCommentState = new State("ONE_STRING_COMMENT");
        State oneStringCommentFinishState = new State("ONE_STRING_COMMENT_FINISH");

        states.put(new Pair<>(startState, ' '), finishState);
        states.put(new Pair<>(startState, '\n'), finishState);
        states.put(new Pair<>(startState, '\r'), finishState);
        states.put(new Pair<>(startState, '\t'), finishState);

        states.put(new Pair<>(startState, '{'), figureBracketState);
        states.put(new Pair<>(startState, '}'), figureBracketState);

        states.put(new Pair<>(startState, '('), roundBracketState);
        states.put(new Pair<>(startState, ')'), roundBracketState);

        states.put(new Pair<>(startState, '['), squareBracketState);
        states.put(new Pair<>(startState, ']'), squareBracketState);

        states.put(new Pair<>(startState, ','), commaState);
        states.put(new Pair<>(startState, '.'), pointState);
        states.put(new Pair<>(startState, ';'), semiColonState);

        states.put(new Pair<>(startState, '\"'), stringLiteralState);
        states.put(new Pair<>(stringLiteralState, '\"'), stringLiteralFinishState);

        states.put(new Pair<>(startState, '/'), divisionState);
        states.put(new Pair<>(divisionState, ' '), divisionStateFinish);

        states.put(new Pair<>(divisionState, '/'), oneStringCommentState);
        states.put(new Pair<>(oneStringCommentState, '\n'), oneStringCommentFinishState);
    }

    /**
     * This method is returning default state
     * @return State - default state
     */
    public State getStartState() {
        return startState;
    }

    /**
     * This method is returning next state for concrete state and signal
     * @param state - input state
     * @param signal - input signal
     * @return State
     */
    public State getNextState(final State state, final Character signal) {
        return states.getOrDefault(new Pair<>(state, signal), state);
    }
}
