package it.sevenbits.formatter.Formatter.Exceptions;

/**
 * Exception for IReader
 */
public class ReadException extends Exception {
    /**
     * @param message - error's message
     */
    public ReadException(final String message) {
        super(message);
    }
}
