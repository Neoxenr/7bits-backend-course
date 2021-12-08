package it.sevenbits.formatter.Formatter.CommandFactory;

import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.Command.WriteCommand;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

public class WriteCommandFactory implements ICommandFactory<IToken, IWriter> {
    /**
     * This method creates WriteCommand
     *
     * @param token  - input token
     * @param writer - output stream
     * @return WriteCommand
     */
    public ICommand createCommand(final IToken token, final IWriter writer) {
        return new WriteCommand(token, writer);
    }
}
