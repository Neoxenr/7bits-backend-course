package it.sevenbits.fourthworkshop.sm.manager.CommandsFactory;

import it.sevenbits.fourthworkshop.sm.manager.Commands.INetworkManagerCommand;
import it.sevenbits.fourthworkshop.sm.manager.Commands.IgnoreCommand;
import it.sevenbits.fourthworkshop.sm.network.NetworkPackage;

public class IgnoreCommandFactory implements ICommandFactory {
    /**
     *
     * @param buffer - input stream
     * @param networkPackage - network package
     * @return INetworkManagerCommand - ignore command
     */
    public INetworkManagerCommand createCommand(final StringBuilder buffer, final NetworkPackage networkPackage) {
        return new IgnoreCommand(buffer, networkPackage);
    }
}
