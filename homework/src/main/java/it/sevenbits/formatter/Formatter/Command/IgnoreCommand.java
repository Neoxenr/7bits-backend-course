package it.sevenbits.formatter.Formatter.Command;

import it.sevenbits.formatter.Formatter.TokenBuilder.ITokenBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IgnoreCommand implements ICommand {
    private final Logger logger = LoggerFactory.getLogger(IgnoreCommand.class);

    /**
     * Command which is ignoring all input parameters and logging info about them
     *
     * @param character    - any symbol
     * @param tokenBuilder - input stream
     */
    public IgnoreCommand(final Character character, final ITokenBuilder tokenBuilder) {
    }

    /**
     * This method is logging info about he has been called
     */
    public void execute() {
        logger.info("The signal has been ignored");
    }
}
