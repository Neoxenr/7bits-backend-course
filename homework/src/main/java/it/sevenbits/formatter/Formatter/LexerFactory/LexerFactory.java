package it.sevenbits.formatter.Formatter.LexerFactory;

import it.sevenbits.formatter.Formatter.Lexer.ILexer;
import it.sevenbits.formatter.Formatter.Lexer.Lexer;
import it.sevenbits.formatter.Formatter.Reader.IReader;

import java.io.IOException;

public class LexerFactory implements ILexerFactory {
    /**
     * This method creates Lexer
     *
     * @param reader - input stream
     * @return ILexer - lexer analyzer
     */
    public ILexer createLexer(final IReader reader) throws IOException {
        return new Lexer(reader);
    }
}
