package it.sevenbits.formatter.Formatter.CommandFactory;

import it.sevenbits.formatter.Formatter.Command.AddCommand;
import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.TokenBuilder.ITokenBuilder;

public class AddCommandFactory implements ICommandFactory<Character, ITokenBuilder> {
    /**
     * This method creates AddCommand
     *
     * @param character    - input symbol
     * @param tokenBuilder - input stream
     * @return AddCommand
     */
    public ICommand createCommand(final Character character, final ITokenBuilder tokenBuilder) {
        return new AddCommand(character, tokenBuilder);
    }
}
