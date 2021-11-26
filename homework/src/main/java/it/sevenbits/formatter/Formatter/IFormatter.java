package it.sevenbits.formatter.Formatter;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;
import it.sevenbits.formatter.Formatter.Reader.IReader;
import it.sevenbits.formatter.Formatter.Writer.IWriter;

import java.io.IOException;

public interface IFormatter {
    /**
     * This method is formatting input stream
     * @param reader - input stream
     * @param writer - output stream
     * @throws ReadException - reading error
     * @throws IOException - stream's error
     */
    void format(IReader reader, IWriter writer) throws ReadException, IOException;
}
