package it.sevenbits.formatter.Formatter.interfaces;

/**
 * Interface with 1 virtual method
 */
public interface IWriter {
    /**
     *
     * @param symbol - symbol for writing in thread
     * @return IWriter - current thread
     */
    IWriter write(char symbol);
}
