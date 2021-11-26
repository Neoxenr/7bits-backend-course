package it.sevenbits.formatter.Formatter.Lexer;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Reader.IReader;
import it.sevenbits.formatter.Formatter.Token.IToken;
import it.sevenbits.formatter.Formatter.Token.Token;

import java.io.IOException;

public class Lexer implements ILexer {
    private final IReader reader;

    private char specialSymbol;

    /**
     *
     * @param reader - input stream
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
        this.specialSymbol = '\0';
    }

    /**
     *
     * @return IToken - token with name and lexeme
     * @throws ReadException - if all tokens are read
     * @throws IOException - stream's error
     */
    public IToken readToken() throws ReadException, IOException {
        if (hasMoreTokens()) {
            StringBuilder lexeme = new StringBuilder();
            while (reader.hasNext()) {
                char symbol;
                if (specialSymbol != '\0') {
                    symbol = specialSymbol;
                    specialSymbol = '\0';
                } else {
                    symbol = reader.read();
                }
                if (symbol != '\n' && symbol != '\r') {
                    if (symbol != ' ') {
                        lexeme.append(symbol);
                        if (symbol == '{' || symbol == '}') {
                            if (lexeme.length() > 1) {
                                specialSymbol = symbol;
                                return new Token("word", lexeme.substring(0, lexeme.length() - 1));
                            }
                            if (lexeme.length() == 1) {
                                return new Token("figure bracket", lexeme.toString());
                            }
                        }
                        if (symbol == '(' || symbol == ')') {
                            if (lexeme.length() > 1) {
                                specialSymbol = symbol;
                                return new Token("word", lexeme.substring(0, lexeme.length() - 1));
                            }
                            if (lexeme.length() == 1) {
                                return new Token("round bracket", lexeme.toString());
                            }
                        }
                        if (symbol == '[' || symbol == ']') {
                            if (lexeme.length() > 1) {
                                specialSymbol = symbol;
                                return new Token("word", lexeme.substring(0, lexeme.length() - 1));
                            }
                            if (lexeme.length() == 1) {
                                return new Token("square bracket", lexeme.toString());
                            }
                        }
                        if (symbol == ';') {
                            if (lexeme.length() > 1) {
                                specialSymbol = symbol;
                                return new Token("word", lexeme.substring(0, lexeme.length() - 1));
                            }
                            if (lexeme.length() == 1) {
                                return new Token("semicolon", lexeme.toString());
                            }
                        }
                        if (symbol == '.') {
                            if (lexeme.length() > 1) {
                                specialSymbol = symbol;
                                return new Token("word", lexeme.substring(0, lexeme.length() - 1));
                            }
                            if (lexeme.length() == 1) {
                                return new Token("point", lexeme.toString());
                            }
                        }
                        if (symbol == ',') {
                            if (lexeme.length() > 1) {
                                specialSymbol = symbol;
                                return new Token("word", lexeme.substring(0, lexeme.length() - 1));
                            }
                            if (lexeme.length() == 1) {
                                return new Token("comma", lexeme.toString());
                            }
                        }
                        if (symbol == '\"') {
                            if (lexeme.length() > 1) {
                                specialSymbol = symbol;
                                return new Token("word", lexeme.substring(0, lexeme.length() - 1));
                            }
                            if (lexeme.length() == 1) {
                                return new Token("quote", lexeme.toString());
                            }
                        }
                    } else {
                        if (lexeme.length() > 0) {
                            return new Token("word", lexeme.toString());
                        }
                    }
                }
            }
        }
        throw new ReadException("Error of token's reading");
    }

    /**
     *
     * @return boolean - if all tokens hasn't read
     * @throws IOException - stream's error
     */
    public boolean hasMoreTokens() throws IOException {
        return reader.hasNext();
    }
}
