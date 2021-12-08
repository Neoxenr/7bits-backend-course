package it.sevenbits.formatter.Formatter.Loader;

import au.com.bytecode.opencsv.CSVReader;
import it.sevenbits.formatter.Formatter.CommandFactory.ICommandFactory;
import it.sevenbits.formatter.Formatter.StateMap.Pair;
import it.sevenbits.formatter.Formatter.StateMap.State;
import it.sevenbits.formatter.Formatter.TokenBuilder.ITokenBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LexerCommandFactoryLoader implements ILoader<Character, ICommandFactory<Character, ITokenBuilder>> {
    private final Map<Pair<State, Character>, ICommandFactory<Character, ITokenBuilder>> commandFactoryMap;

    /**
     * commandFactoryMap initializing
     */
    public LexerCommandFactoryLoader() {
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
                requireNonNull(getClass().getResourceAsStream("/config/lexerCommandFactoryMap.csv")))), ',')) {
            List<String[]> strings = csvReader.readAll();
            for (int i = 1; i < strings.size(); i++) {
                for (int j = 1; j < strings.get(0).length; j++) {
                    if (strings.get(i)[j].length() > 0) {
                        try {
                            Class<?> clazz = Class.forName("it.sevenbits.formatter.Formatter.CommandFactory." + strings.get(i)[j]);
                            commandFactoryMap.put(new Pair<>(new State(strings.get(i)[0]), (char) Integer.parseInt(strings.get(0)[j])),
                                    (ICommandFactory<Character, ITokenBuilder>) clazz.getDeclaredConstructor().newInstance());
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
     * Returning map of command factories
     *
     * @return Map - map of command factories
     */
    public Map<Pair<State, Character>, ICommandFactory<Character, ITokenBuilder>> get() {
        return commandFactoryMap;
    }
}
