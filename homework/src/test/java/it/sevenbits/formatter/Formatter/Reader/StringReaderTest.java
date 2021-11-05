package it.sevenbits.formatter.Formatter.Reader;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Reader.StringReader;
import org.junit.Test;

public class StringReaderTest {
    @Test(expected = ReadException.class)
    public void readReadExceptionTest() throws ReadException {
        StringReader stringReader = new StringReader("Hello, World!");
        while (stringReader.hasNext()) {
            stringReader.read();
        }
        stringReader.read();
    }
}
