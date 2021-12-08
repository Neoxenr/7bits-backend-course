package it.sevenbits.formatter.Formatter.CommandRepository;

import it.sevenbits.formatter.Formatter.CommandFactory.ICommandFactory;
import it.sevenbits.formatter.Formatter.StateMap.State;

public interface ICommandRepository<Signal, Stream> {
    /**
     * This method returning commands factory for concrete state and signal
     *
     * @param state  - input state
     * @param signal - input signal
     * @return ICommandFactory
     */
    ICommandFactory<Signal, Stream> getCommand(State state, Signal signal);
}
