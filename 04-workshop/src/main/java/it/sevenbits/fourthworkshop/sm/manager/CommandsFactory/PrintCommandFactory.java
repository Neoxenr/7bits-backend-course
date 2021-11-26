package it.sevenbits.fourthworkshop.sm.manager.CommandsFactory;

import it.sevenbits.fourthworkshop.sm.manager.Commands.INetworkManagerCommand;
import it.sevenbits.fourthworkshop.sm.manager.Commands.PrintCommand;
import it.sevenbits.fourthworkshop.sm.network.NetworkPackage;

public class PrintCommandFactory implements ICommandFactory {
    /**
     *
     * @param buffer - input stream
     * @param networkPackage - network package
     * @return INetworkManagerCommand - print command
     */
    public INetworkManagerCommand createCommand(final StringBuilder buffer, final NetworkPackage networkPackage) {
        return new PrintCommand(buffer, networkPackage);
    }
}
