package it.sevenbits.formatter.Formatter.Command;

import it.sevenbits.formatter.Formatter.TokenBuilder.ITokenBuilder;

public class AddCommand implements ICommand {
    private final Character character;
    private final ITokenBuilder tokenBuilder;

    /**
     * Command which is adding symbol in input stream (ITokenBuilder)
     *
     * @param character    - adding symbol
     * @param tokenBuilder - input stream
     */
    public AddCommand(final Character character, final ITokenBuilder tokenBuilder) {
        this.character = character;
        this.tokenBuilder = tokenBuilder;
    }

    /**
     * This method adding symbol in input stream
     */
    public void execute() {
        tokenBuilder.addSymbol(character);
    }
}
