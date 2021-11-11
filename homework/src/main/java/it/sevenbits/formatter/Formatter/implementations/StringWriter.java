package it.sevenbits.formatter.Formatter.implementations;

import it.sevenbits.formatter.Formatter.interfaces.IWriter;

/**
 * IWriter's implementation
 */
public class StringWriter implements IWriter {
    private final StringBuilder string;

    /**
     *
     * @param string - string for writing
     */
    public StringWriter(final StringBuilder string) {
        this.string = string;
    }

    /**
     *
     * @param symbol - symbor for writing in thread
     * @return IWriter - current thread
     */
    public IWriter write(final char symbol) {
        string.append(symbol);
        return this;
    }
}
