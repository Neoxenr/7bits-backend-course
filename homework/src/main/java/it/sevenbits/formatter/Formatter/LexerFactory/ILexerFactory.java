package it.sevenbits.formatter.Formatter.LexerFactory;

import it.sevenbits.formatter.Formatter.Lexer.ILexer;
import it.sevenbits.formatter.Formatter.Reader.IReader;

public interface ILexerFactory {
    /**
     *
     * @param reader - input stream
     * @return ILexer - lexer for lexical analyze
     */
    ILexer createLexer(IReader reader);
}
