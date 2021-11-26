package it.sevenbits.fourthworkshop.sm.manager.Commands;

import it.sevenbits.fourthworkshop.sm.manager.CommandsFactory.ICommandFactory;
import it.sevenbits.fourthworkshop.sm.manager.CommandsFactory.IgnoreCommandFactory;
import it.sevenbits.fourthworkshop.sm.manager.CommandsFactory.PrintCommandFactory;
import it.sevenbits.fourthworkshop.sm.manager.CommandsFactory.StopCommandFactory;
import it.sevenbits.fourthworkshop.sm.manager.CommandsFactory.WriteCommandFactory;
import it.sevenbits.fourthworkshop.sm.manager.StateMachine.Pair;
import it.sevenbits.fourthworkshop.sm.manager.StateMachine.State;

import java.util.HashMap;
import java.util.Map;

public class CommandsRepository {
    private final Map<Pair<State, String>, ICommandFactory> commands;

    /**
     * Initialization commands and putting command to map
     */
    public CommandsRepository() {
        commands = new HashMap<>();

          // для packagesFillerTaskOne
//        commands.put(new Pair<>(new State("IGNORE"), "MESSAGE"), new WriteCommandFactory());
//        commands.put(new Pair<>(new State("IGNORE"), "TRASH"), new IgnoreCommandFactory());
//
//        commands.put(new Pair<>(new State("LISTEN"), "MESSAGE"), new WriteCommandFactory());
//        commands.put(new Pair<>(new State("LISTEN"), "TRASH"), new IgnoreCommandFactory());
//
//        commands.put(new Pair<>(new State("TRASH_SUSPICION"), "MESSAGE"), new WriteCommandFactory());
//        commands.put(new Pair<>(new State("TRASH_SUSPICION"), "TRASH"), new StopCommandFactory());


        // для packagesFillerTaskTwo
        commands.put(new Pair<>(new State("IGNORE"), "MESSAGE_START"), new WriteCommandFactory());

        commands.put(new Pair<>(new State("LISTEN"), "MESSAGE_FINISH"), new PrintCommandFactory());
        commands.put(new Pair<>(new State("LISTEN"), "MESSAGE"), new WriteCommandFactory());
        commands.put(new Pair<>(new State("LISTEN"), "TRASH"), new IgnoreCommandFactory());

        commands.put(new Pair<>(new State("TRASH_SUSPICION"), "MESSAGE_FINISH"), new PrintCommandFactory());
        commands.put(new Pair<>(new State("TRASH_SUSPICION"), "MESSAGE"), new WriteCommandFactory());
        commands.put(new Pair<>(new State("TRASH_SUSPICION"), "TRASH"), new StopCommandFactory());
    }

    /**
     *
     * @param state - current state
     * @param signal - input signal
     * @return ICommandFactory - factory for commands
     */
    public ICommandFactory getFactoryCommand(final State state, final String signal) {
        return commands.getOrDefault(new Pair<>(state, signal), new IgnoreCommandFactory());
    }
}
