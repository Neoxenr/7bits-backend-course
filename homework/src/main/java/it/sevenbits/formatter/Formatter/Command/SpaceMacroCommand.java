package it.sevenbits.formatter.Formatter.Command;

import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.IOException;

public class SpaceMacroCommand implements ICommand {
    private final IToken token;
    private final IWriter writer;
    private final SpaceCommand spaceCommand;
    private final WriteCommand writeCommand;

    /**
     * Command which is adding space and writing symbols in output stream
     *
     * @param token  - token
     * @param writer - output stream
     */
    public SpaceMacroCommand(final IToken token, final IWriter writer) {
        this.token = token;
        this.writer = writer;
        this.spaceCommand = new SpaceCommand(token, writer);
        this.writeCommand = new WriteCommand(token, writer);
    }

    /**
     * This method executes two commands
     *
     * @throws IOException - stream's error
     */
    public void execute() throws IOException {
        spaceCommand.execute();
        writeCommand.execute();
    }
}
