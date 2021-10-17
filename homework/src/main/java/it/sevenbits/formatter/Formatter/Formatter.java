package it.sevenbits.formatter.Formatter;

import it.sevenbits.formatter.Formatter.exceptions.ReadException;
import it.sevenbits.formatter.Formatter.interfaces.IReader;
import it.sevenbits.formatter.Formatter.interfaces.IWriter;

/**
 * This class is formatting strings according to java conventions
 */
public class Formatter {
    /**
     *
     * @param reader - thread for reading
     * @param writer - thread for writing
     * @throws ReadException - if nothing to read
     */
    public void format(final IReader reader, final IWriter writer) throws ReadException {
        boolean newSpace = false, newLine = false;

        final int tabulationSize = 4;

        int indent = 0;

        while (reader.hasNext()) {
            char symbol = reader.read();
            if (symbol != ' ' && symbol != '\n') {
                if (newLine) {
                    if (symbol == '}') {
                        indent -= tabulationSize;
                    }
                    for (int i = 0; i < indent; i++) {
                        writer.write(' ');
                    }
                    newLine = false;
                }
                if (symbol == '}') {
                    writer.write(symbol).write('\n');
                    newLine = true;
                }
                if (symbol == '{') {
                    if (newSpace) {
                        writer.write(' ');
                    }
                    writer.write(symbol).write('\n');
                    newSpace = false;
                    newLine = true;
                    indent += tabulationSize;
                }
                if (symbol == ';') {
                    writer.write(symbol).write('\n');
                    newSpace = false;
                    newLine = true;
                }
                if (symbol != '{' && symbol != '}' && symbol != ';') {
                    writer.write(symbol);
                    newSpace = true;
                }
            } else {
                if (newSpace) {
                    writer.write(symbol);
                    newSpace = false;
                }
            }
        }
    }
}
