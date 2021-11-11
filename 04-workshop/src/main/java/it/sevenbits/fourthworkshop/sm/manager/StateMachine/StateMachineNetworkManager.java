package it.sevenbits.fourthworkshop.sm.manager.StateMachine;

import it.sevenbits.fourthworkshop.sm.log.MessageFormatter;
import it.sevenbits.fourthworkshop.sm.manager.CommandsFactory.ICommandFactory;
import it.sevenbits.fourthworkshop.sm.manager.Commands.CommandsRepository;
import it.sevenbits.fourthworkshop.sm.manager.Commands.INetworkManagerCommand;
import it.sevenbits.fourthworkshop.sm.manager.INetworkManager;
import it.sevenbits.fourthworkshop.sm.manager.NetworkManagerException;
import it.sevenbits.fourthworkshop.sm.network.INetwork;
import it.sevenbits.fourthworkshop.sm.network.NetworkPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateMachineNetworkManager implements INetworkManager {

    private boolean isInterrupted = false;
    private final long TIMEOUT = 500;
    private final StateTransition stateTransition;
    private final CommandsRepository commandsRepository;
    private final Logger logger = LoggerFactory.getLogger(StateMachineNetworkManager.class);
    private final MessageFormatter messageFormatter;

    /**
     * Objects initialization
     */
    public StateMachineNetworkManager() {
        this.stateTransition = new StateTransition();
        this.commandsRepository = new CommandsRepository();
        this.messageFormatter = new MessageFormatter();
    }

    /**
     *
     * @param network - input network
     * @throws NetworkManagerException - if network manager was interrupted unexpectedly
     */
    public void listen(final INetwork network) throws NetworkManagerException {
        State currentState = stateTransition.getStartState();
        StringBuilder buffer = new StringBuilder();
        try {
            while (!isInterrupted) {
                while (network.hasPackage()) {
                    NetworkPackage p = network.getPackage();
                    logger.info(String.format(messageFormatter.getStringFormatByType(p.getType()), p.getMessage()));
                    ICommandFactory factory = commandsRepository.getFactoryCommand(currentState, p.getType());
                    INetworkManagerCommand command = factory.createCommand(buffer, p);
                    command.execute();
                    currentState = stateTransition.nextState(currentState, p);
                    //System.out.println(String.format("%1$s: %2$s", p.getType(), currentState.toString()));
                }
                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e) {
            logger.error("Network manager was interrupted unexpectedly", e);
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);
        }
    }

    /**
     * state machine network manager stop
     */
    public void stop() {
        logger.info("State machine network manager has been stopped");
        isInterrupted = true;
    }
}
