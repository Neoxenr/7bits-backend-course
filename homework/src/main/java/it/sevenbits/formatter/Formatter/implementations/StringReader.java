package it.sevenbits.formatter.Formatter.implementations;

import it.sevenbits.formatter.Formatter.exceptions.ReadException;
import it.sevenbits.formatter.Formatter.interfaces.IReader;

/**
 * IReader's implementation
 */
public class StringReader implements IReader {
    private final String string;

    private int stringCounter = 0;

    /**
     *
     * @param string - string for reading
     */
    public StringReader(final String string) {
        this.string = string;
    }

    /**
     *
     * @return boolean - true if string hasn't finished yet else false
     */
    public boolean hasNext() {
        return stringCounter < string.length();
    }

    /**
     *
     * @return char - symbol from string
     * @throws ReadException - if nothing to read
     */
    public char read() throws ReadException {
        if (!hasNext()) {
            throw new ReadException("Error of reading");
        }
        return string.charAt(stringCounter++);
    }
}
