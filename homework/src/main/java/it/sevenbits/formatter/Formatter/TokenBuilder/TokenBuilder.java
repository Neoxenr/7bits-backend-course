package it.sevenbits.formatter.Formatter.TokenBuilder;

import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Token.Token;

public class TokenBuilder implements ITokenBuilder {
    private final StringBuilder lexeme;
    private String name;

    /**
     * Initializing all fields
     */
    public TokenBuilder() {
        lexeme = new StringBuilder();
        name = "";
    }

    /**
     * This method is setting name token
     *
     * @param tokenName - new token's name
     */
    public void setTokenName(final String tokenName) {
        name = tokenName;
    }

    /**
     * This method is adding symbol in stream
     *
     * @param signal - input signal
     */
    public void addSymbol(final char signal) {
        lexeme.append(signal);
    }

    /**
     * This method creates new token
     *
     * @return IToken
     */
    public IToken createToken() {
        return new Token(name, lexeme.toString());
    }

    /**
     * This method returns current lexeme's size
     *
     * @return int
     */
    public int lexemeSize() {
        return lexeme.length();
    }
}
