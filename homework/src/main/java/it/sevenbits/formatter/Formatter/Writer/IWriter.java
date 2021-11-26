package it.sevenbits.formatter.Formatter.Writer;

import java.io.IOException;

/**
 * Interface with 1 virtual method
 */
public interface IWriter {
    /**
     * This method writes symbol in output stream
     * @param symbol - symbol for writing in thread
     * @return IWriter - current thread
     */
    IWriter write(char symbol) throws IOException;
}
