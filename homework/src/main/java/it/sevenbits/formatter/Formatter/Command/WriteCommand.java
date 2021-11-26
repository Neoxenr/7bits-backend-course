package it.sevenbits.formatter.Formatter.Command;

import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.IOException;

public class WriteCommand implements ICommand {
    private final IToken token;
    private final IWriter writer;

    /**
     * Command which is adding symbols in output stream
     * @param token - token
     * @param writer - output stream
     */
    public WriteCommand(final IToken token, final IWriter writer) {
        this.token = token;
        this.writer = writer;
    }

    /**
     * This method is adding symbol in output stream
     * @throws IOException - stream's error
     */
    public void execute() throws IOException {
        for (int i = 0; i < token.getLexeme().length(); i++) {
            writer.write(token.getLexeme().charAt(i));
        }
    }
}
