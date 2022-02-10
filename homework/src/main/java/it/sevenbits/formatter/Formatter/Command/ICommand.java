package it.sevenbits.formatter.Formatter.Command;

import java.io.IOException;

public interface ICommand {
    /**
     * Method which is execute any action
     *
     * @throws IOException - stream's error
     */
    void execute() throws IOException;
}
