package it.sevenbits.formatter.Formatter;

import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.CommandFactory.ICommandFactory;
import it.sevenbits.formatter.Formatter.CommandRepository.FormatterCommandRepository;
import it.sevenbits.formatter.Formatter.CommandRepository.ICommandRepository;
import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Lexer.ILexer;
import it.sevenbits.formatter.Formatter.LexerFactory.ILexerFactory;
import it.sevenbits.formatter.Formatter.Reader.IReader;
import it.sevenbits.formatter.Formatter.StateMap.State;
import it.sevenbits.formatter.Formatter.StateTransition.FormatterStateTransition;
import it.sevenbits.formatter.Formatter.StateTransition.IStateTransition;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.IOException;

/**
 * This class is formatting strings according to java conventions
 */
public class Formatter implements IFormatter {
    private final IStateTransition<IToken> formatterLexerTransition;
    private final ICommandRepository<IToken, IWriter> commandRepository;
    private final ILexerFactory lexerFactory;

    /**
     * Initializing all fields
     *
     * @param lexerFactory - factory for ILexer products
     */
    public Formatter(final ILexerFactory lexerFactory) throws IOException {
        this.formatterLexerTransition = new FormatterStateTransition();
        this.commandRepository = new FormatterCommandRepository();
        this.lexerFactory = lexerFactory;
    }

    /**
     * This method is formatting input stream
<<<<<<< HEAD
     *
=======
>>>>>>> master
     * @param reader - input stream
     * @param writer - output stream
     * @throws IOException   - stream's error
     * @throws ReadException - if all tokens are read
     */
    public void format(final IReader reader, final IWriter writer) throws IOException, ReadException {
        State currentState = formatterLexerTransition.getStartState();
        ILexer lexer = lexerFactory.createLexer(reader);

        while (lexer.hasMoreTokens()) {
            IToken token = lexer.nextToken();

            if (token.getLexeme().length() == 0) {
                continue;
            }

            ICommandFactory<IToken, IWriter> commandFactory = commandRepository.getCommand(currentState, token);
            ICommand command = commandFactory.createCommand(token, writer);
            command.execute();

            currentState = formatterLexerTransition.getNextState(currentState, token);
        }
    }
}
