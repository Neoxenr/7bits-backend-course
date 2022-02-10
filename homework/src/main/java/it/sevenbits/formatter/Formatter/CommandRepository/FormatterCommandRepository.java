package it.sevenbits.formatter.Formatter.CommandRepository;

import it.sevenbits.formatter.Formatter.CommandFactory.ICommandFactory;
import it.sevenbits.formatter.Formatter.CommandFactory.WriteCommandFactory;
import it.sevenbits.formatter.Formatter.Loader.FormatterCommandFactoryLoader;
import it.sevenbits.formatter.Formatter.Loader.ILoader;
import it.sevenbits.formatter.Formatter.StateMap.Pair;
import it.sevenbits.formatter.Formatter.StateMap.State;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.IOException;
import java.util.Map;

public class FormatterCommandRepository implements ICommandRepository<IToken, IWriter> {
    private final Map<Pair<State, IToken>, ICommandFactory<IToken, IWriter>> commandFactories;

    /**
     * Initializing commandFactories
     */
    public FormatterCommandRepository() throws IOException {
        ILoader<IToken, ICommandFactory<IToken, IWriter>> commandFactoryILoader = new FormatterCommandFactoryLoader();
        commandFactoryILoader.load();

        commandFactories = commandFactoryILoader.get();
    }

    /**
     * This method is returning commands factory for concrete state and signal
     *
     * @param state - input state
     * @param token - input token
     * @return ICommandFactory
     */
    public ICommandFactory<IToken, IWriter> getCommand(final State state, final IToken token) {
        return commandFactories.getOrDefault(new Pair<>(state, token), new WriteCommandFactory());
    }
}
