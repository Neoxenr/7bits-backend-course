package it.sevenbits.formatter.Formatter.Reader;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;

import java.io.IOException;

/**
 * Interface with 2 virtual methods
 */
public interface IReader {
    /**
     * This method is returning true if reading stream hasn't ended yet
     * @return boolean - if thread hasn't finished yet else false
     */
    boolean hasNext() throws IOException;

    /**
     * This method is reading symbol from input stream
     * @return char - symbol from thread
     * @throws ReadException - if nothing to read
     */
    char read() throws ReadException, IOException;
}
