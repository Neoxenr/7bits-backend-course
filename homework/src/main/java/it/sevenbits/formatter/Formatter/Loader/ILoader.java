package it.sevenbits.formatter.Formatter.Loader;

import it.sevenbits.formatter.Formatter.StateMap.Pair;
import it.sevenbits.formatter.Formatter.StateMap.State;

import java.io.IOException;
import java.util.Map;

public interface ILoader<Signal, Output> {
    /**
     * Loading .csv file and map initializing
     *
     * @throws IOException - stream's exception
     */
    void load() throws IOException;

    /**
     * Returning map of transitions or command factories
     *
     * @return Map - map of transitions or command factories
     */
    Map<Pair<State, Signal>, Output> get();
}
