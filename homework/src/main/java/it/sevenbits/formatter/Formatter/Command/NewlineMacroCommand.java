package it.sevenbits.formatter.Formatter.Command;

import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.IOException;

public class NewlineMacroCommand implements ICommand  {
    private final IToken token;
    private final IWriter writer;
    private final WriteCommand writeCommand;
    private final NewlineCommand newlineCommand;

    /**
     * Command which is adding switching to a new line and writing symbols in output stream
     * @param token - token
     * @param writer - output stream
     */
    public NewlineMacroCommand(final IToken token, final IWriter writer) {
        this.token = token;
        this.writer = writer;
        this.writeCommand = new WriteCommand(token, writer);
        this.newlineCommand = new NewlineCommand(token, writer);
    }

    /**
     * This method executes two commands
     * @throws IOException - stream's error
     */
    public void execute() throws IOException {
        writeCommand.execute();
        newlineCommand.execute();
    }
}
