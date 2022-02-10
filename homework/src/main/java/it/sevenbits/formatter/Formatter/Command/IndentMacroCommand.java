package it.sevenbits.formatter.Formatter.Command;

import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.IOException;

public class IndentMacroCommand implements ICommand {
    private final IToken token;
    private final IWriter writer;
    private final WriteCommand writeCommand;
    private final IndentCommand indentCommand;

    /**
     * Command which is adding indent before symbols and writing symbols in output stream
     *
     * @param token  - token
     * @param writer - output stream
     */
    public IndentMacroCommand(final IToken token, final IWriter writer) {
        this.token = token;
        this.writer = writer;
        this.indentCommand = new IndentCommand(token, writer);
        this.writeCommand = new WriteCommand(token, writer);
    }

    /**
     * This method executes two commands
     *
     * @throws IOException - stream's error
     */
    public void execute() throws IOException {
        indentCommand.execute();
        writeCommand.execute();
    }
}
