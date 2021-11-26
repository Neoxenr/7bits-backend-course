package it.sevenbits.formatter.Formatter.Token;

public class Token implements IToken {
    private final String name;
    private final String lexeme;

    /**
     *
     * @param name - token name
     * @param lexeme - lexeme
     */
    public Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }

    /**
     *
     * @return String - token name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return String - lexeme
     */
    public String getLexeme() {
        return lexeme;
    }
}
