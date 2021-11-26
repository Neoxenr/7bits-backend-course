package it.sevenbits.formatter.Formatter.Command;

import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.IOException;

public class SpaceCommand implements ICommand {
    private final IToken token;
    private final IWriter writer;

    /**
     * Command which is adding space in output stream
     * @param token - token
     * @param writer - output stream
     */
    public SpaceCommand(final IToken token, final IWriter writer) {
        this.token = token;
        this.writer = writer;
    }

    /**
     * This method adding space in output stream
     * @throws IOException - stream's error
     */
    public void execute() throws IOException {
        writer.write(' ');
    }
}
