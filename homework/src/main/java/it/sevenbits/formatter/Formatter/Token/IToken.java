package it.sevenbits.formatter.Formatter.Token;

public interface IToken {
    /**
     *
     * @return String - token name
     */
    String getName();

    /**
     *
     * @return String - lexeme
     */
    String getLexeme();
}
