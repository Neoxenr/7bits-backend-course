package it.sevenbits.formatter.Formatter.Loader;

import au.com.bytecode.opencsv.CSVReader;
import it.sevenbits.formatter.Formatter.CommandFactory.ICommandFactory;
import it.sevenbits.formatter.Formatter.StateMap.Pair;
import it.sevenbits.formatter.Formatter.StateMap.State;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Token.Token;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FormatterCommandFactoryLoader implements ILoader<IToken, ICommandFactory<IToken, IWriter>> {
    private final Map<Pair<State, IToken>, ICommandFactory<IToken, IWriter>> commandFactoryMap;

    /**
     * commandFactoryMap initializing
     */
    public FormatterCommandFactoryLoader() {
        commandFactoryMap = new HashMap<>();
    }

    /**
     * Loading .csv file and map initializing
     *
     * @throws IOException - stream's error
     */
    @SuppressWarnings("unchecked")
    public void load() throws IOException {
        try (CSVReader csvReader = new CSVReader(new BufferedReader(new InputStreamReader(Objects.
                requireNonNull(getClass().getResourceAsStream("/config/formatterCommandFactoryMap.csv")))), ',')) {
            List<String[]> strings = csvReader.readAll();
            for (int i = 1; i < strings.size(); i++) {
                for (int j = 1; j < strings.get(0).length; j++) {
                    if (strings.get(i)[j].length() > 0) {
                        try {
                            Class<?> clazz = Class.forName("it.sevenbits.formatter.Formatter.CommandFactory." + strings.get(i)[j]);
                            commandFactoryMap.put(new Pair<>(new State(strings.get(i)[0]), new Token(strings.get(0)[j], "")),
                                    (ICommandFactory<IToken, IWriter>) clazz.getDeclaredConstructor().newInstance());
                        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
                                | IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * Returning of command factories
     *
     * @return Map - map of command factories
     */
    public Map<Pair<State, IToken>, ICommandFactory<IToken, IWriter>> get() {
        return commandFactoryMap;
    }
}
