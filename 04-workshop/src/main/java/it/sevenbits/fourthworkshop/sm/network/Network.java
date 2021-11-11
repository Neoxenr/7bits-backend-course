package it.sevenbits.fourthworkshop.sm.network;

import it.sevenbits.fourthworkshop.sm.manager.StateMachine.StateMachineNetworkManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Network implements INetwork {
    private final int maxSize;
    private final ConcurrentLinkedDeque<NetworkPackage> packages = new ConcurrentLinkedDeque<>();
    private final Logger logger = LoggerFactory.getLogger(StateMachineNetworkManager.class);

    /**
     *
     * @param maxSize - network's size
     */
    public Network(final int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     *
     * @return boolean - true if package is available yet
     */
    public boolean hasPackage() {
        return packages.size() > 0;
    }


    /**
     *
     * @return NetworkPackage - concrete network package
     */
    public NetworkPackage getPackage() {
        logger.debug("Package has been received");
        return packages.removeFirst();
    }

    /**
     *
     * @param message - package's message
     * @param type - package's type
     */
    public void addPackage(final String message, final String type) {
        if (packages.size() < maxSize) {
            logger.debug("Package has been added");
            packages.addLast(new NetworkPackage(type, message));
        }
        logger.error("Packet's limit has been exceeded");
    }
}
