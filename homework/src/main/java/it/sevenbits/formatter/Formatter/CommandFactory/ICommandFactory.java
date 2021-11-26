package it.sevenbits.formatter.Formatter.CommandFactory;

import it.sevenbits.formatter.Formatter.Command.ICommand;

public interface ICommandFactory<Signal, Stream> {
    /**
     * This method creates commands
     * @param signal - input signal
     * @param stream - input stream
     * @return ICommand
     */
    ICommand createCommand(Signal signal, Stream stream);
}
