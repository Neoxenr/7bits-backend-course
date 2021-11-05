package it.sevenbits.formatter.Formatter.Writer;

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
     * @param symbol - symbol for writing in thread
     * @return IWriter - output stream
     */
    public IWriter write(final char symbol) {
        string.append(symbol);
        return this;
    }
}
