package it.sevenbits.formatter.Formatter.CommandFactory;

import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.Command.IgnoreCommand;
import it.sevenbits.formatter.Formatter.TokenBuilder.ITokenBuilder;

public class IgnoreCommandFactory implements ICommandFactory<Character, ITokenBuilder> {
    /**
     * This method creates IgnoreCommand
     *
     * @param character    - input symbol
     * @param tokenBuilder - input stream
     * @return IgnoreCommand
     */
    public ICommand createCommand(final Character character, final ITokenBuilder tokenBuilder) {
        return new IgnoreCommand(character, tokenBuilder);
    }
}
