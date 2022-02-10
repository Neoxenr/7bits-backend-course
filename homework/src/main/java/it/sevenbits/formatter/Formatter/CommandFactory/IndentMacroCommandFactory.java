package it.sevenbits.formatter.Formatter.CommandFactory;

import it.sevenbits.formatter.Formatter.Command.IndentMacroCommand;
import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

public class IndentMacroCommandFactory implements ICommandFactory<IToken, IWriter> {
    /**
     * This method creates IndentMacroCommand
     * @param token - input token
     * @param writer - output stream
     * @return IndentMacroCommand
     */
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new IndentMacroCommand(token, writer);
    }
}
