package it.sevenbits.thirdworkshop.User.Exceptions;

public class UserManagerException extends Exception {
    /**
     *
     * @param s - exception's message
     */
    public UserManagerException(final String s) {
        super(s);
    }

    /**
     *
     * @param message - exception's message
     * @param cause - stack trace
     */
    public UserManagerException(final String message, final Throwable cause) {
        super(message, cause);
    }
}