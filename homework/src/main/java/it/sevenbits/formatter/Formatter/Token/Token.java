package it.sevenbits.formatter.Formatter.Token;

import java.util.Objects;

public class Token implements IToken {
    private final String name;
    private final String lexeme;

    /**
     * Initializing all fields
     *
     * @param name   - token name
     * @param lexeme - lexeme
     */
    public Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }

    /**
     * This method is returning token's name
     *
     * @return String - token's name
     */
    public String getName() {
        return name;
    }

    /**
     * This method is returning lexeme
     *
     * @return String - lexeme
     */
    public String getLexeme() {
        return lexeme;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Token token = (Token) o;
        return Objects.equals(name, token.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
