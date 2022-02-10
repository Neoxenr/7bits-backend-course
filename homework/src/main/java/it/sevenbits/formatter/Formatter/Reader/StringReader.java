package it.sevenbits.formatter.Formatter.Reader;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;

/**
 * IReader's implementation
 */
public class StringReader implements IReader {
    private final String string;

    private int symbolCounter = 0;

    /**
     * Initializing fields
     *
     * @param string - string for reading
     */
    public StringReader(final String string) {
        this.string = string;
    }

    /**
     * This method is returning true if reading stream hasn't ended yet
     *
     * @return boolean - if reading a stream hasn't ended yet
     */
    public boolean hasNext() {
        return symbolCounter < string.length();
    }

    /**
     * This method is reading symbol from input stream
     *
     * @return char - symbol from stream
     * @throws ReadException - if all symbols are read
     */
    public char read() throws ReadException {
        if (!hasNext()) {
            throw new ReadException("Error of string's reading");
        }
        return string.charAt(symbolCounter++);
    }
}
