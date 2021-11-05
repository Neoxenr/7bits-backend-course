package it.sevenbits.formatter.Formatter.Lexer;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Token.IToken;

import java.io.IOException;

public interface ILexer {
    /**
     *
     * @return boolean - true if all tokens hasn't read
     * @throws IOException - stream's error
     */
    boolean hasMoreTokens() throws IOException;

    /**
     *
     * @return IToken - token
     * @throws ReadException - reading error
     * @throws IOException - stream's error
     */
    IToken readToken() throws ReadException, IOException;
}
