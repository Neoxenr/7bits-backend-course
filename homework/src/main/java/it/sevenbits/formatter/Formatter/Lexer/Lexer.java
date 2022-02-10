package it.sevenbits.formatter.Formatter.Lexer;

import it.sevenbits.formatter.Formatter.Command.ICommand;
import it.sevenbits.formatter.Formatter.CommandFactory.ICommandFactory;
import it.sevenbits.formatter.Formatter.CommandRepository.ICommandRepository;
import it.sevenbits.formatter.Formatter.CommandRepository.LexerCommandRepository;
import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Reader.IReader;
import it.sevenbits.formatter.Formatter.StateMap.State;
import it.sevenbits.formatter.Formatter.StateTransition.IStateTransition;
import it.sevenbits.formatter.Formatter.StateTransition.LexerStateTransition;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.TokenBuilder.ITokenBuilder;
import it.sevenbits.formatter.Formatter.TokenBuilder.TokenBuilder;

import java.io.IOException;

public class Lexer implements ILexer {
    private final IStateTransition<java.lang.Character> lexerStateTransition;
    private final ICommandRepository<java.lang.Character, ITokenBuilder> commandRepository;
    private final IReader reader;
    private char specialSymbol;

    /**
     * Initializing all fields
     *
     * @param reader - input stream
     */
    public Lexer(final IReader reader) throws IOException {
        this.lexerStateTransition = new LexerStateTransition();
        this.commandRepository = new LexerCommandRepository();
        this.reader = reader;
        this.specialSymbol = '\0';
    }

    /**
     * This method is returning tokens
     *
     * @return IToken
     * @throws IOException   - stream's error
     * @throws ReadException - reading error
     */
    public IToken nextToken() throws IOException, ReadException {
        ITokenBuilder tokenBuilder = new TokenBuilder();

        State currentState = lexerStateTransition.getStartState();

        if (hasMoreTokens()) {
            while (reader.hasNext() && !currentState.toString().contains("FINISH")) {
                char symbol;

                if (specialSymbol == '\0') {
                    symbol = reader.read();
                } else {
                    symbol = specialSymbol;
                    specialSymbol = '\0';
                }

                int currentLexemeSize = tokenBuilder.lexemeSize();

                ICommandFactory<Character, ITokenBuilder> commandFactory = commandRepository.getCommand(currentState, symbol);
                ICommand command = commandFactory.createCommand(symbol, tokenBuilder);
                command.execute();

                if (currentLexemeSize == tokenBuilder.lexemeSize() && tokenBuilder.lexemeSize() > 0) {
                    specialSymbol = symbol;
                    symbol = ' ';
                }

                currentState = lexerStateTransition.getNextState(currentState, symbol);
                tokenBuilder.setTokenName(currentState.toString());
            }
            if (currentState.toString().contains("_FINISH")) {
                tokenBuilder.setTokenName(currentState.toString().substring(0, currentState.toString().indexOf("_FINISH")));
            }
        } else {
            throw new ReadException("Token's reading error");
        }

        return tokenBuilder.createToken();
    }

    /**
     * This method is returning true if all tokens hasn't read yet
     *
     * @return boolean - if all tokens hasn't read
     * @throws IOException - stream's error
     */
    public boolean hasMoreTokens() throws IOException {
        return reader.hasNext();
    }
}
