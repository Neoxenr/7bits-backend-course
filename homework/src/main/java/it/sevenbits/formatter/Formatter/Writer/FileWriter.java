package it.sevenbits.formatter.Formatter.Writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class FileWriter implements IWriter, AutoCloseable {
    private final Writer fileWriter;

    /**
     * Initializing all fields
     *
     * @param path - file path
     * @throws FileNotFoundException - if file isn't founded
     */
    public FileWriter(final String path) throws FileNotFoundException {
        fileWriter = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8);
    }

    /**
     * This method writes symbol in output stream
     *
     * @param symbol - symbol for writing in thread
     * @return IWriter - output stream
     * @throws IOException - stream's error
     */
    public IWriter write(final char symbol) throws IOException {
        fileWriter.write(symbol);
        return this;
    }

    /**
     * This method closes output stream
     *
     * @throws Exception - stream's error
     */
    public void close() throws Exception {
        fileWriter.close();
    }
}
