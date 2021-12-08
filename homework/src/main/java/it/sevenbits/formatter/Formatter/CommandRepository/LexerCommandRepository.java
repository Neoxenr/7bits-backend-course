package it.sevenbits.formatter.Formatter.CommandRepository;

import it.sevenbits.formatter.Formatter.CommandFactory.AddCommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.ICommandFactory;
import it.sevenbits.formatter.Formatter.Loader.ILoader;
import it.sevenbits.formatter.Formatter.Loader.LexerCommandFactoryLoader;
import it.sevenbits.formatter.Formatter.StateMap.Pair;
import it.sevenbits.formatter.Formatter.StateMap.State;
import it.sevenbits.formatter.Formatter.TokenBuilder.ITokenBuilder;

import java.io.IOException;
import java.util.Map;

public class LexerCommandRepository implements ICommandRepository<Character, ITokenBuilder> {
    private final Map<Pair<State, Character>, ICommandFactory<Character, ITokenBuilder>> commandFactoryMap;

    /**
     * Initializing commandFactories
     */
    public LexerCommandRepository() throws IOException {
        ILoader<Character, ICommandFactory<Character, ITokenBuilder>> commandFactoryILoader = new LexerCommandFactoryLoader();
        commandFactoryILoader.load();

        commandFactoryMap = commandFactoryILoader.get();
    }

    /**
     * This method returning commands factory for concrete state and signal
     *
     * @param state     - input state
     * @param character - input symbol
     * @return ICommandFactory
     */
    public ICommandFactory<Character, ITokenBuilder> getCommand(final State state, final Character character) {
        return commandFactoryMap.getOrDefault(new Pair<>(state, character), new AddCommandFactory());
    }
}
