package it.sevenbits.formatter.Formatter.Command;

import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.IOException;

public class IndentCommand implements ICommand {
    private final IToken token;
    private final IWriter writer;
    private static int indentSize = 0;
    private static String prevTokenName = "";

    /**
     * Command which is adding indent before symbols
     *
     * @param token  - input token
     * @param writer - input stream
     */
    public IndentCommand(final IToken token, final IWriter writer) {
        this.token = token;
        this.writer = writer;
    }

    /**
     * This method interacts and regulates indent
     *
     * @throws IOException - stream's error
     */
    public void execute() throws IOException {
        final int tabulationSize = 4;

        if (token.getLexeme().equals("}")) {
            indentSize -= tabulationSize;
        }
        if (!token.getLexeme().equals("{") || !prevTokenName.equals("WORD")) {
            for (int i = 0; i < indentSize; i++) {
                writer.write(' ');
            }
        }
        if (token.getLexeme().equals("{")) {
            indentSize += tabulationSize;
        }

        prevTokenName = token.getName();
    }
}
