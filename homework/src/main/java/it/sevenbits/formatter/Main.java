package it.sevenbits.formatter;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Formatter;
import it.sevenbits.formatter.Formatter.LexerFactory.ILexerFactory;
import it.sevenbits.formatter.Formatter.LexerFactory.LexerFactory;
import it.sevenbits.formatter.Formatter.Reader.FileReader;
import it.sevenbits.formatter.Formatter.Writer.FileWriter;

/**
 * Main application entry point
 */
final class Main {
    /**
     * Main function for app
     * @param args - console arguments
     * @throws ReadException - reading exception
     */
    public static void main(final String[] args) throws Exception {
        if (args.length > 0) {
            try (FileReader reader = new FileReader(args[0])) {
                try (FileWriter writer = new FileWriter(args[1])) {
                    ILexerFactory lexerFactory = new LexerFactory();
                    Formatter formatter = new Formatter(lexerFactory);

                    formatter.format(reader, writer);
                }
            }
        }
    }
    private Main() {}
}