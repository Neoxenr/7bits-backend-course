package it.sevenbits.formatter.Formatter.Token;

public interface IToken {
    /**
     * This method is returning token's name
     *
     * @return String - token's name
     */
    String getName();

    /**
     * This method is returning lexeme
     *
     * @return String - lexeme
     */
    String getLexeme();
}
