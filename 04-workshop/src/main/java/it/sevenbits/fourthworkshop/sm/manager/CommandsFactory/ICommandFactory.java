package it.sevenbits.fourthworkshop.sm.manager.CommandsFactory;

import it.sevenbits.fourthworkshop.sm.manager.Commands.INetworkManagerCommand;
import it.sevenbits.fourthworkshop.sm.network.NetworkPackage;

public interface ICommandFactory {
    /**
     *
     * @param buffer - input stream
     * @param networkPackage - network package
     * @return INetworkManagerCommand - command
     */
    INetworkManagerCommand createCommand(StringBuilder buffer, NetworkPackage networkPackage);
}
