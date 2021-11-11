package it.sevenbits.fourthworkshop.sm.manager.CommandsFactory;

import it.sevenbits.fourthworkshop.sm.manager.Commands.INetworkManagerCommand;
import it.sevenbits.fourthworkshop.sm.manager.Commands.StopCommand;
import it.sevenbits.fourthworkshop.sm.network.NetworkPackage;

public class StopCommandFactory implements ICommandFactory {
    /**
     *
     * @param buffer - input stream
     * @param networkPackage - network package
     * @return INetworkManagerCommand - stop command
     */
    public INetworkManagerCommand createCommand(final StringBuilder buffer, final NetworkPackage networkPackage) {
        return new StopCommand(buffer, networkPackage);
    }
}
