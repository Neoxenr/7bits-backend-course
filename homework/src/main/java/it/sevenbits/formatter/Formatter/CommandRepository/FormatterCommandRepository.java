package it.sevenbits.formatter.Formatter.CommandRepository;

import it.sevenbits.formatter.Formatter.CommandFactory.IndentSpaceMacroCommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.NewlineMacroCommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.IndentMacroCommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.ICommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.IndentNewlineMacroCommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.SpaceMacroCommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.WriteCommandFactory;
import it.sevenbits.formatter.Formatter.StateMap.Pair;
import it.sevenbits.formatter.Formatter.StateMap.State;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Token.Token;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.util.HashMap;
import java.util.Map;

public class FormatterCommandRepository implements ICommandRepository<IToken, IWriter> {
    private final Map<Pair<State, IToken>, ICommandFactory<IToken, IWriter>> commandFactories;

    /**
     * Initializing commandFactories
     */
    public FormatterCommandRepository() {
        commandFactories = new HashMap<>();

        State startState = new State("DEFAULT_STATE");
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

        commandFactories.put(new Pair<>(startState, oneStringCommentToken), new NewlineMacroCommandFactory());
        commandFactories.put(new Pair<>(startState, wordToken), new IndentMacroCommandFactory());
        commandFactories.put(new Pair<>(startState, figureBracketToken), new IndentNewlineMacroCommandFactory());

        commandFactories.put(new Pair<>(oneStringCommentState, oneStringCommentToken), new NewlineMacroCommandFactory());
        commandFactories.put(new Pair<>(oneStringCommentState, figureBracketToken), new IndentNewlineMacroCommandFactory());
        commandFactories.put(new Pair<>(oneStringCommentState, wordToken), new IndentMacroCommandFactory());

        commandFactories.put(new Pair<>(wordState, wordToken), new SpaceMacroCommandFactory());
        commandFactories.put(new Pair<>(wordState, stringLiteralToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(wordState, divisionToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(wordState, semicolonToken), new NewlineMacroCommandFactory());
        commandFactories.put(new Pair<>(wordState, figureBracketToken), new IndentSpaceMacroCommandFactory());

        commandFactories.put(new Pair<>(figureBracketState, figureBracketToken), new IndentNewlineMacroCommandFactory());
        commandFactories.put(new Pair<>(figureBracketState, wordToken), new IndentMacroCommandFactory());

        commandFactories.put(new Pair<>(semicolonState, wordToken), new IndentMacroCommandFactory());
        commandFactories.put(new Pair<>(semicolonState, figureBracketToken), new IndentNewlineMacroCommandFactory());

        commandFactories.put(new Pair<>(wordState, pointToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(pointState, pointToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(pointState, wordToken), new WriteCommandFactory());

        commandFactories.put(new Pair<>(wordState, commaToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(commaState, commaToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(commaState, wordToken), new SpaceMacroCommandFactory());

        commandFactories.put(new Pair<>(wordState, roundBracketToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(roundBracketState, roundBracketToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(roundBracketState, wordToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(roundBracketState, figureBracketToken), new IndentSpaceMacroCommandFactory());
        commandFactories.put(new Pair<>(roundBracketState, semicolonToken), new NewlineMacroCommandFactory());
        commandFactories.put(new Pair<>(roundBracketState, stringLiteralToken), new WriteCommandFactory());

        commandFactories.put(new Pair<>(wordState, squareBracketToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(squareBracketState, squareBracketToken), new WriteCommandFactory());
        commandFactories.put(new Pair<>(squareBracketState, wordToken), new SpaceMacroCommandFactory());
    }

    /**
     * This method is returning commands factory for concrete state and signal
     * @param state - input state
     * @param token - input token
     * @return ICommandFactory
     */
    public ICommandFactory<IToken, IWriter> getCommand(final State state, final IToken token) {
        return commandFactories.getOrDefault(new Pair<>(state, token), new WriteCommandFactory());
    }
}
