package it.sevenbits.formatter.Formatter.Lexer;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Token.IToken;

import java.io.IOException;

public interface ILexer {
    /**
     * This method is returning true if all tokens hasn't read yet
     *
     * @return boolean - true if all tokens hasn't read
     * @throws IOException - stream's error
     */
    boolean hasMoreTokens() throws IOException;

    /**
     * This method is returning next token
     *
     * @return IToken - token
     * @throws ReadException - reading error
     * @throws IOException   - stream's error
     */
    IToken nextToken() throws ReadException, IOException;
}
