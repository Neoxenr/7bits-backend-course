package it.sevenbits.formatter.Formatter;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Lexer.ILexer;
import it.sevenbits.formatter.Formatter.LexerFactory.ILexerFactory;
import it.sevenbits.formatter.Formatter.Reader.IReader;
import it.sevenbits.formatter.Formatter.Writer.IWriter;
import it.sevenbits.formatter.Formatter.Token.IToken;

import java.io.IOException;

/**
 * This class is formatting strings according to java conventions
 */
public class Formatter implements IFormatter {
    private final ILexerFactory lexerFactory;

    /**
     *
     * @param lexerFactory - factory for ILexer products
     */
    public Formatter(final ILexerFactory lexerFactory) {
        this.lexerFactory = lexerFactory;
    }

    /**
     *
     * @param reader - input stream
     * @param writer - output stream
     * @throws IOException - stream's error
     * @throws ReadException - if all tokens are read
     */
    public void format(final IReader reader, final IWriter writer) throws IOException, ReadException {
        ILexer lexer = lexerFactory.createLexer(reader);

        boolean newSpace = false;
        boolean newLine = false;

        final int tabulationSize = 4;

        int spaceCount = 0;

        while (lexer.hasMoreTokens()) {
            IToken token = lexer.readToken();
            String lexeme = token.getLexeme();
            String tokenName = token.getName();

            if (newLine) {
                if (lexeme.equals("}")) {
                    spaceCount -= tabulationSize;
                }
                for (int i = 0; i < spaceCount; i++) {
                    writer.write(' ');
                }
                newLine = false;
            }

            if (tokenName.equals("point") || tokenName.equals("quote")) {
                writer.write(lexeme.charAt(0));
                newSpace = false;
            }

            if (tokenName.equals("comma")) {
                writer.write(lexeme.charAt(0));
                newSpace = true;
            }

            if (tokenName.equals("square bracket")) {
                if (lexeme.equals("]")) {
                    newSpace = true;
                }
                writer.write(lexeme.charAt(0));
            }

            if (tokenName.equals("round bracket")) {
                writer.write(lexeme.charAt(0));
                if (lexeme.equals("(")) {
                    newSpace = false;
                }
            }

            if (tokenName.equals("figure bracket") || tokenName.equals("semicolon")) {
                if (lexeme.equals("{")) {
                    if (newSpace) {
                        writer.write(' ');
                    }
                    spaceCount += tabulationSize;
                }
                writer.write(lexeme.charAt(0)).write('\n');
                newSpace = false;
                newLine = true;
            }

            if (tokenName.equals("word")) {
                if (newSpace) {
                    writer.write(' ');
                }
                for (int i = 0; i < lexeme.length(); i++) {
                    writer.write(lexeme.charAt(i));
                }
                newSpace = true;
            }
        }
    }
}