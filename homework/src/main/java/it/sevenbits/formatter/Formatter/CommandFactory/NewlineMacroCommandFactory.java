package it.sevenbits.formatter.Formatter.CommandFactory;

import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.Command.NewlineMacroCommand;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

public class NewlineMacroCommandFactory implements ICommandFactory<IToken, IWriter> {
    /**
     * This method creates NewlineMacroCommand
     *
     * @param token  - input token
     * @param writer - output stream
     * @return NewlineMacroCommand
     */
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new NewlineMacroCommand(token, writer);
    }
}
