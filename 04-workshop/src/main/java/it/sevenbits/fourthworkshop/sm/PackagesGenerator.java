package it.sevenbits.fourthworkshop.sm;

import it.sevenbits.fourthworkshop.sm.manager.INetworkManager;
import it.sevenbits.fourthworkshop.sm.network.INetwork;

import java.util.Random;

public class PackagesGenerator {
    private final String[] messages = {
            "First", "Second", "Third", "Hi Mark", "Msg"
    };
    private final String trash = "************";
    private final String senselessMsg = "##(!@)";
    
    private final long DEFAULT_TIMEOUT = 10;
    private final int DEFAULT_ITERATIONS_COUNT = 500;

    /**
     *
     * @param nm - network manager
     * @param network - network
     * @return Thread - some thread
     */
    public Thread packagesFillerTaskOne(final INetworkManager nm, final INetwork network) {
        return new Thread(() -> {
            System.out.println("[Task one] packages generator started");
            int count = 0;
            Random rand = new Random();
            while (count < DEFAULT_ITERATIONS_COUNT) {
                count++;
                boolean isStub = rand.nextBoolean();
                if (!isStub) {
                    network.addPackage(messages[count % messages.length], "MESSAGE");
                    continue;
                }

                network.addPackage(trash, "TRASH");
                try {
                    Thread.sleep(DEFAULT_TIMEOUT);
                } catch (InterruptedException e) {
                    break;
                }
            }
            nm.stop();
        });
    }

    /**
     *
     * @param nm - network manager
     * @param network - network
     * @return Thread - some thread
     */
    public Thread packagesFillerTaskTwo(final INetworkManager nm, final INetwork network) {
        return new Thread(() -> {
            System.out.println("[Task two] packages generator started");
            int count = 0;
            Random rand = new Random();
            while (count < DEFAULT_ITERATIONS_COUNT) {
                count++;
                boolean isMessage = rand.nextBoolean();
                if (isMessage) {
                    network.addPackage(senselessMsg, "MESSAGE_START");
                    int index = count % messages.length;
                    for (int i = 0; i <= index; i++) {
                        network.addPackage(messages[index], "MESSAGE");
                    }

                    index = (index - 1) % messages.length - 1;
                    for (int i = 0; i < index; i++) {
                        network.addPackage(trash, "TRASH");
                    }
                    network.addPackage(senselessMsg, "MESSAGE_FINISH");
                    continue;
                }

                network.addPackage(trash, "TRASH");
                try {
                    Thread.sleep(DEFAULT_TIMEOUT);
                } catch (InterruptedException e) {
                    break;
                }
            }
            nm.stop();
        });
    }
}
