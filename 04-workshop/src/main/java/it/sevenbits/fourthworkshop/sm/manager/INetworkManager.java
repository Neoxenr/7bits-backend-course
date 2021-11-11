package it.sevenbits.fourthworkshop.sm.manager;

import it.sevenbits.fourthworkshop.sm.network.INetwork;

public interface INetworkManager {
    /**
     *
     * @param network - input network
     * @throws NetworkManagerException - if network manager was interrupted unexpectedly
     */
    void listen(INetwork network) throws NetworkManagerException;

    /**
     * network manager stop
     */
    void stop();
}
