package it.sevenbits.formatter.Formatter.CommandFactory;

import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.Command.IndentNewlineMacroCommand;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

public class IndentNewlineMacroCommandFactory implements ICommandFactory<IToken, IWriter> {
    /**
     * This method creates IndentNewlineMacroCommand
     *
     * @param token  - input token
     * @param writer - output stream
     * @return IndentNewlineMacroCommand
     */
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new IndentNewlineMacroCommand(token, writer);
    }
}
