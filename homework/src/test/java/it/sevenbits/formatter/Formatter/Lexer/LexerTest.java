package it.sevenbits.formatter.Formatter.Lexer;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Lexer.ILexer;
import it.sevenbits.formatter.Formatter.Lexer.Lexer;
import it.sevenbits.formatter.Formatter.Reader.StringReader;
import it.sevenbits.formatter.Formatter.Token.Token;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LexerTest {
    @Test
    public void mockReadTokenWordTest() throws IOException, ReadException {
        Lexer mockLexer = mock(Lexer.class);
        when(mockLexer.readToken()).thenReturn(new Token("word", "aaa"));
        assertEquals("Wrong token name", "word", mockLexer.readToken().getName());
        assertEquals("Wrong token lexeme", "aaa", mockLexer.readToken().getLexeme());
    }
    @Test
    public void mockReadTokenFigureBracketTest() throws IOException, ReadException {
        Lexer mockLexer = mock(Lexer.class);
        when(mockLexer.readToken()).thenReturn(new Token("figure bracket", "{"));
        assertEquals("Wrong token name", "figure bracket", mockLexer.readToken().getName());
        assertEquals("Wrong token lexeme", "{", mockLexer.readToken().getLexeme());
    }
    @Test
    public void mockReadTokenCommaTest() throws IOException, ReadException {
        Lexer mockLexer = mock(Lexer.class);
        when(mockLexer.readToken()).thenReturn(new Token("comma", ","));
        assertEquals("Wrong token name", "comma", mockLexer.readToken().getName());
        assertEquals("Wrong token lexeme", ",", mockLexer.readToken().getLexeme());
    }
    @Test (expected = ReadException.class)
    public void readTokenReadExceptionTest() throws IOException, ReadException {
        StringReader stringReader = new StringReader("aaa{bb;}");
        ILexer lexer = new Lexer(stringReader);
        while(lexer.hasMoreTokens()) {
            lexer.readToken();
        }
        lexer.readToken();
    }
}
