package it.sevenbits.fourthworkshop.sm.manager.Commands;

import it.sevenbits.fourthworkshop.sm.network.NetworkPackage;

public class PrintCommand implements INetworkManagerCommand {
    private final StringBuilder buffer;
    private final NetworkPackage networkPackage;

    /**
     *
     * @param buffer - input stream
     * @param networkPackage - network package
     */
    public PrintCommand(final StringBuilder buffer, final NetworkPackage networkPackage) {
        this.buffer = buffer;
        this.networkPackage = networkPackage;
    }

    /**
     * command's executing
     */
    public void execute() {
        System.out.println("MESSAGE FINISHED: " + buffer.toString());
    }
}
