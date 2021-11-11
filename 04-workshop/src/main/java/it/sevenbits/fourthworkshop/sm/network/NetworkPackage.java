package it.sevenbits.fourthworkshop.sm.network;

public class NetworkPackage {
    private final String type;

    private final String message;

    /**
     *
     * @param type - package's type
     * @param message - package's message
     */
    public NetworkPackage(final String type, final String message) {
        this.type = type;
        this.message = message;
    }

    /**
     *
     * @return String - package's type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return String - package's type
     */
    public String getMessage() {
        return message;
    }
}
