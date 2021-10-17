package it.sevenbits.formatter.Formatter.exceptions;

/**
 * Exception for IReader
 */
public class ReadException extends Exception {
    /**
     *
     * @param message - error's message
     */
    public ReadException(final String message) {
        super(message);
    }
}
