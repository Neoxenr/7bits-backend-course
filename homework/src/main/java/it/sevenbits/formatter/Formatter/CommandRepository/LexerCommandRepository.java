package it.sevenbits.formatter.Formatter.CommandRepository;

import it.sevenbits.formatter.Formatter.CommandFactory.AddCommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.DodgeCommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.ICommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.IgnoreCommandFactory;
import it.sevenbits.formatter.Formatter.StateMap.Pair;
import it.sevenbits.formatter.Formatter.StateMap.State;
import it.sevenbits.formatter.Formatter.TokenBuilder.ITokenBuilder;

import java.util.HashMap;
import java.util.Map;

public class LexerCommandRepository implements ICommandRepository<Character, ITokenBuilder> {
    private final Map<Pair<State, Character>, ICommandFactory<Character, ITokenBuilder>> commandFactories;

    /**
     * Initializing commandFactories
     */
    public LexerCommandRepository() {
        commandFactories = new HashMap<>();

        State startState = new State("WORD");
        State stringLiteralState = new State("STRING_LITERAL");
        State divisionState = new State("DIVISION");
        State oneStringCommentState = new State("ONE_STRING_COMMENT");

        commandFactories.put(new Pair<>(startState, ' '), new IgnoreCommandFactory());
        commandFactories.put(new Pair<>(startState, '\n'), new IgnoreCommandFactory());
        commandFactories.put(new Pair<>(startState, '\r'), new IgnoreCommandFactory());
        commandFactories.put(new Pair<>(startState, '\t'), new IgnoreCommandFactory());

        commandFactories.put(new Pair<>(startState, '{'), new DodgeCommandFactory());
        commandFactories.put(new Pair<>(startState, '}'), new DodgeCommandFactory());

        commandFactories.put(new Pair<>(startState, '('), new DodgeCommandFactory());
        commandFactories.put(new Pair<>(startState, ')'), new DodgeCommandFactory());

        commandFactories.put(new Pair<>(startState, '['), new DodgeCommandFactory());
        commandFactories.put(new Pair<>(startState, ']'), new DodgeCommandFactory());

        commandFactories.put(new Pair<>(startState, ','), new DodgeCommandFactory());
        commandFactories.put(new Pair<>(startState, '.'), new DodgeCommandFactory());
        commandFactories.put(new Pair<>(startState, ';'), new DodgeCommandFactory());

        commandFactories.put(new Pair<>(startState, '\"'), new DodgeCommandFactory());
        commandFactories.put(new Pair<>(stringLiteralState, '\"'), new AddCommandFactory());

        commandFactories.put(new Pair<>(startState, '/'), new AddCommandFactory());
        commandFactories.put(new Pair<>(divisionState, ' '), new IgnoreCommandFactory());

        commandFactories.put(new Pair<>(divisionState, '/'), new AddCommandFactory());
        commandFactories.put(new Pair<>(oneStringCommentState, '\n'), new AddCommandFactory());
    }

    /**
     * This method returning commands factory for concrete state and signal
     * @param state - input state
     * @param character - input symbol
     * @return ICommandFactory
     */
    public ICommandFactory<Character, ITokenBuilder> getCommand(final State state, final Character character) {
        return commandFactories.getOrDefault(new Pair<>(state, character), new AddCommandFactory());
    }
}
