/**
 * This package intends for storing all commands
 * ICommand - interface for all commands
 * AddCommand is adding symbol in input stream (ITokenBuilder)
 * DodgeCommand is adding symbol if input stream is empty
 * IgnoreCommand is ignoring all input parameters and logging info about them
 * IndentCommand is adding indent before symbols
 * IndentMacroCommand is adding indent before symbols and writing symbols in output stream
 * IndentNewlineMacroCommand is adding indent, switching to a new line and writing symbols in output stream
 * IndentSpaceMacroCommand is adding indent, switching to a new line, space and writing symbols in output stream
 * NewlineCommand is adding switching to a new line in output stream
 * NewlineMacroCommand is adding switching to a new line and writing symbols in output stream
 * SpaceCommand is adding space in output stream
 * SpaceMacroCommand is adding space and writing symbols in output stream
 * WriteCommand is adding symbols in output stream
 */
package it.sevenbits.formatter.Formatter.Command;