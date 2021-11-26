package it.sevenbits.formatter.Formatter.CommandFactory;

import it.sevenbits.formatter.Formatter.Command.DodgeCommand;
import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.TokenBuilder.ITokenBuilder;

public class DodgeCommandFactory implements ICommandFactory<Character, ITokenBuilder> {
    /**
     * This method creates DodgeCommand
     * @param character - input symbol
     * @param tokenBuilder - input strem
     * @return DodgeCommand
     */
    public ICommand createCommand(final Character character, final ITokenBuilder tokenBuilder) {
        return new DodgeCommand(character, tokenBuilder);
    }
}
