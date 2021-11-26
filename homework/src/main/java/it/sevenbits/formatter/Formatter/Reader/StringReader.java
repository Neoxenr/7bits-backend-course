package it.sevenbits.formatter.Formatter.Reader;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;

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
     * @return boolean - if reading a stream hasn't ended yet
     */
    public boolean hasNext() {
        return stringCounter < string.length();
    }

    /**
     *
     * @return char - symbol from stream
     * @throws ReadException - if all symbols are read
     */
    public char read() throws ReadException {
        if (!hasNext()) {
            throw new ReadException("Error of string's reading");
        }
        return string.charAt(stringCounter++);
    }
}
