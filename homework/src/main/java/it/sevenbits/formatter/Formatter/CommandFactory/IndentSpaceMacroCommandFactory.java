package it.sevenbits.formatter.Formatter.CommandFactory;

import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.Command.IndentSpaceMacroCommand;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

public class IndentSpaceMacroCommandFactory implements ICommandFactory<IToken, IWriter> {
    /**
     * This method creates IndentSpaceMacroCommand
     *
     * @param token  - input token
     * @param writer - output stream
     * @return IndentSpaceMacroCommand
     */
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new IndentSpaceMacroCommand(token, writer);
    }
}
