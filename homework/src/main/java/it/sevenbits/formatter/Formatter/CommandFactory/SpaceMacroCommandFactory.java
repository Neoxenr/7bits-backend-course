package it.sevenbits.formatter.Formatter.CommandFactory;

import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.Command.SpaceMacroCommand;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

public class SpaceMacroCommandFactory implements ICommandFactory<IToken, IWriter> {
    /**
     * This method creates SpaceMacroCommand
     * @param token - input token
     * @param writer - output stream
     * @return SpaceMacroCommand
     */
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new SpaceMacroCommand(token, writer);
    }
}
