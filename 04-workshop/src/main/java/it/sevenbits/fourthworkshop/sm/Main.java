package it.sevenbits.fourthworkshop.sm;

import it.sevenbits.fourthworkshop.sm.manager.INetworkManager;
import it.sevenbits.fourthworkshop.sm.manager.StateMachine.StateMachineNetworkManager;
import it.sevenbits.fourthworkshop.sm.network.INetwork;
import it.sevenbits.fourthworkshop.sm.network.Network;

final class Main {
    /**
     *
     * @param args - console arguments
     * @throws Exception - potential exception
     */
    public static void main(final String[] args) throws Exception {
//      final INetworkManager nm = new SimpleNetworkManager();
        final INetworkManager nm = new StateMachineNetworkManager();
        final INetwork network = new Network(500);

        PackagesGenerator packagesGenerator = new PackagesGenerator();
//      Thread createMessagesThread = packagesGenerator.packagesFillerTaskOne(nm, network);
        Thread createMessagesThread = packagesGenerator.packagesFillerTaskTwo(nm, network);

        createMessagesThread.start();
        nm.listen(network);
    }
    private Main() {}
}
