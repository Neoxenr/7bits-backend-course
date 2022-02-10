package it.sevenbits.formatter.Formatter.Command;

import it.sevenbits.formatter.Formatter.TokenBuilder.ITokenBuilder;

public class DodgeCommand implements ICommand {
    private final Character character;
    private final ITokenBuilder tokenBuilder;

    /**
     * Command which is adding symbol if input stream is empty
     *
     * @param character    - adding symbol
     * @param tokenBuilder - input stream
     */
    public DodgeCommand(final Character character, final ITokenBuilder tokenBuilder) {
        this.character = character;
        this.tokenBuilder = tokenBuilder;
    }

    /**
     * This method adding symbol if input stream is empty
     */
    public void execute() {
        if (tokenBuilder.lexemeSize() == 0) {
            tokenBuilder.addSymbol(character);
        }
    }
}
