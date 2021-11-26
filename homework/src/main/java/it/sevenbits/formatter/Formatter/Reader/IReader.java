package it.sevenbits.formatter.Formatter.Reader;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;

import java.io.IOException;

/**
 * Interface with 2 virtual methods
 */
public interface IReader {
    /**
     *
     * @return boolean - if thread hasn't finished yet else false
     */
    boolean hasNext() throws IOException;

    /**
     *
     * @return char - symbol from thread
     * @throws ReadException - if nothing to read
     */
    char read() throws ReadException, IOException;
}
