package it.sevenbits.fourthworkshop.sm.manager.CommandsFactory;

import it.sevenbits.fourthworkshop.sm.manager.Commands.INetworkManagerCommand;
import it.sevenbits.fourthworkshop.sm.manager.Commands.WriteCommand;
import it.sevenbits.fourthworkshop.sm.network.NetworkPackage;

public class WriteCommandFactory implements ICommandFactory {
    /**
     *
     * @param buffer - input stream
     * @param networkPackage - network package
     * @return INetworkManagerCommand - write command
     */
    public INetworkManagerCommand createCommand(final StringBuilder buffer, final NetworkPackage networkPackage) {
        return new WriteCommand(buffer, networkPackage);
    }
}
