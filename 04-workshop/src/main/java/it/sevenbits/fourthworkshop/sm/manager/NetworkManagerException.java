package it.sevenbits.fourthworkshop.sm.manager;

public class NetworkManagerException extends Exception {
    /**
     *
     * @param message - error's message
     * @param cause - exception
     */
    public NetworkManagerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param message - error's message
     */
    public NetworkManagerException(final String message) {
        super(message);
    }
}
