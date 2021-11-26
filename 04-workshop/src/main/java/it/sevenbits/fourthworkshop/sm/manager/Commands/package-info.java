/**
 * This package intends for INetworkManagerCommand interface and him implementations
 * INetworkManagerCommand - interface with 1 method execute for all commands
 * CommandsRepository - vault for all commands
 * IgnoreCommand - this command is ignoring all if signal is TRASH
 * PrintCommand - this command writes in console result if signal is MESSAGE_FINISH
 * StopCommand - this command writes in console result and cleans buffer if signal is TRASH
 * WriteCommand - this command writes in buffer message if signal is MESSAGE
 */
package it.sevenbits.fourthworkshop.sm.manager.Commands;