package it.sevenbits.formatter.Formatter.TokenBuilder;

import it.sevenbits.formatter.Formatter.Token.IToken;

public interface ITokenBuilder {
    /**
     * This method is adding symbol in stream
     *
     * @param signal - input signal
     */
    void addSymbol(char signal);

    /**
     * This method is setting name token
     *
     * @param name - new token's name
     */
    void setTokenName(String name);

    /**
     * This method creates new token
     *
     * @return IToken
     */
    IToken createToken();

    /**
     * This method returns current lexeme's size
     *
     * @return int
     */
    int lexemeSize();
}
