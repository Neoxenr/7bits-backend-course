package it.sevenbits.formatter.Formatter.Command;

import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.IOException;

public class IndentSpaceMacroCommand implements ICommand {
    private final IToken token;
    private final IWriter writer;
    private final SpaceCommand spaceCommand;
    private final WriteCommand writeCommand;
    private final NewlineCommand newlineCommand;
    private final IndentCommand indentCommand;

    /**
     * Command which is adding indent, switching to a new line, space and writing symbols in output stream
     *
     * @param token  - token
     * @param writer - output stream
     */
    public IndentSpaceMacroCommand(final IToken token, final IWriter writer) {
        this.token = token;
        this.writer = writer;
        this.spaceCommand = new SpaceCommand(token, writer);
        this.writeCommand = new WriteCommand(token, writer);
        this.newlineCommand = new NewlineCommand(token, writer);
        this.indentCommand = new IndentCommand(token, writer);
    }

    /**
     * This method executes four commands
     *
     * @throws IOException - stream's error
     */
    public void execute() throws IOException {
        spaceCommand.execute();
        writeCommand.execute();
        newlineCommand.execute();
        indentCommand.execute();
    }
}
