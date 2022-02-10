package it.sevenbits.formatter.Formatter.StateMap;

import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Token.Token;

import java.util.HashMap;
import java.util.Map;

public class FormatterStateMap implements IStateMap<IToken> {
    private final Map<Pair<State, IToken>, State> states;

    private final State startState;

    /**
     * Initializing all states
     */
    public FormatterStateMap() {
        states = new HashMap<>();

        startState = new State("DEFAULT_STATE");

        State oneStringCommentState = new State("ONE_STRING_COMMENT");
        State figureBracketState = new State("FIGURE_BRACKET");
        State roundBracketState = new State("ROUND_BRACKET");
        State squareBracketState = new State("SQUARE_BRACKET");
        State wordState = new State("WORD");
        State semicolonState = new State("SEMICOLON");
        State pointState = new State("POINT");
        State commaState = new State("COMMA");

        IToken wordToken = new Token("WORD", "");
        IToken figureBracketToken = new Token("FIGURE_BRACKET", "");
        IToken squareBracketToken = new Token("SQUARE_BRACKET", "");
        IToken roundBracketToken = new Token("ROUND_BRACKET", "");
        IToken commaToken = new Token("COMMA", "");
        IToken pointToken = new Token("POINT", "");
        IToken semicolonToken = new Token("SEMICOLON", "");
        IToken stringLiteralToken = new Token("STRING_LITERAL", "");
        IToken divisionToken = new Token("DIVISION", "");
        IToken oneStringCommentToken = new Token("ONE_STRING_COMMENT", "");

        states.put(new Pair<>(startState, oneStringCommentToken), oneStringCommentState);
        states.put(new Pair<>(startState, wordToken), wordState);
        states.put(new Pair<>(startState, figureBracketToken), figureBracketState);

        states.put(new Pair<>(oneStringCommentState, oneStringCommentToken), oneStringCommentState);
        states.put(new Pair<>(oneStringCommentState, figureBracketToken), startState);
        states.put(new Pair<>(oneStringCommentState, wordToken), wordState);

        states.put(new Pair<>(wordState, wordToken), wordState);
        states.put(new Pair<>(wordState, stringLiteralToken), wordState);
        states.put(new Pair<>(wordState, divisionToken), wordState);
        states.put(new Pair<>(wordState, semicolonToken), semicolonState);
        states.put(new Pair<>(wordState, figureBracketToken), figureBracketState);

        states.put(new Pair<>(figureBracketState, figureBracketToken), figureBracketState);
        states.put(new Pair<>(figureBracketState, wordToken), wordState);

        states.put(new Pair<>(semicolonState, wordToken), wordState);
        states.put(new Pair<>(semicolonState, figureBracketToken), startState);

        states.put(new Pair<>(wordState, pointToken), pointState);
        states.put(new Pair<>(pointState, pointToken), pointState);
        states.put(new Pair<>(pointState, wordToken), wordState);

        states.put(new Pair<>(wordState, commaToken), commaState);
        states.put(new Pair<>(commaState, commaToken), commaState);
        states.put(new Pair<>(commaState, wordToken), wordState);

        states.put(new Pair<>(wordState, roundBracketToken), roundBracketState);
        states.put(new Pair<>(roundBracketState, roundBracketToken), roundBracketState);
        states.put(new Pair<>(roundBracketState, wordToken), wordState);
        states.put(new Pair<>(roundBracketState, figureBracketToken), figureBracketState);
        states.put(new Pair<>(roundBracketState, semicolonToken), semicolonState);
        states.put(new Pair<>(roundBracketState, stringLiteralToken), roundBracketState);

        states.put(new Pair<>(wordState, squareBracketToken), squareBracketState);
        states.put(new Pair<>(squareBracketState, squareBracketToken), squareBracketState);
        states.put(new Pair<>(squareBracketState, wordToken), wordState);
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
    public State getNextState(final State state, final IToken signal) {
        return states.getOrDefault(new Pair<>(state, signal), startState);
    }
}
