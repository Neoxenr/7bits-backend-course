package it.sevenbits.formatter.Formatter.interfaces;

import it.sevenbits.formatter.Formatter.exceptions.ReadException;

/**
 * Interface with 2 virtual methods
 */
public interface IReader {
    /**
     *
     * @return boolean - if thread hasn't finished yet else false
     */
    boolean hasNext();

    /**
     *
     * @return char - symbol from thread
     * @throws ReadException - if nothing to read
     */
    char read() throws ReadException;
}
