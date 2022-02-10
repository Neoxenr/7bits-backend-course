package it.sevenbits.formatter.Formatter.Lexer;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Reader.StringReader;
import it.sevenbits.formatter.Formatter.Token.Token;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LexerTest {
    @Test
    public void mockReadTokenWordTest() throws IOException, ReadException {
        Lexer mockLexer = mock(Lexer.class);
        when(mockLexer.nextToken()).thenReturn(new Token("WORD", "aaa"));
        assertEquals("Wrong token name", "WORD", mockLexer.nextToken().getName());
        assertEquals("Wrong token lexeme", "aaa", mockLexer.nextToken().getLexeme());
    }

    @Test
    public void mockReadTokenFigureBracketTest() throws IOException, ReadException {
        Lexer mockLexer = mock(Lexer.class);
        when(mockLexer.nextToken()).thenReturn(new Token("FIGURE_BRACKET", "{"));
        assertEquals("Wrong token name", "FIGURE_BRACKET", mockLexer.nextToken().getName());
        assertEquals("Wrong token lexeme", "{", mockLexer.nextToken().getLexeme());
    }

    @Test
    public void mockReadTokenCommaTest() throws IOException, ReadException {
        Lexer mockLexer = mock(Lexer.class);
        when(mockLexer.nextToken()).thenReturn(new Token("COMMA", ","));
        assertEquals("Wrong token name", "COMMA", mockLexer.nextToken().getName());
        assertEquals("Wrong token lexeme", ",", mockLexer.nextToken().getLexeme());
    }

    @Test(expected = ReadException.class)
    public void readTokenReadExceptionTest() throws IOException, ReadException, InvocationTargetException, InstantiationException, IllegalAccessException {
        StringReader stringReader = new StringReader("aaa{bb;}");
        ILexer lexer = new Lexer(stringReader);
        while (lexer.hasMoreTokens()) {
            lexer.nextToken();
        }
        lexer.nextToken();
    }
}
