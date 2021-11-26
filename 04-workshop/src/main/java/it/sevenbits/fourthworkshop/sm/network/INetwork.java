package it.sevenbits.fourthworkshop.sm.network;

public interface INetwork {

    /**
     *
     * @return boolean - true if package is available yet
     */
    boolean hasPackage();

    /**
     *
     * @return NetworkPackage - concrete network package
     */
    NetworkPackage getPackage();

    /**
     *
     * @param message - package's message
     * @param type - package's type
     */
    void addPackage(String message, String type);
}
