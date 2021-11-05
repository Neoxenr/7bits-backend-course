package it.sevenbits.formatter.Formatter.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class FileWriter implements IWriter, AutoCloseable {
    private final Writer fileWriter;

    /**
     *
     * @param path - file path
     * @throws FileNotFoundException - if file isn't founded
     */
    public FileWriter(final String path) throws FileNotFoundException {
        fileWriter =  new OutputStreamWriter(new FileOutputStream(new File(path)), StandardCharsets.UTF_8);
    }

    /**
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
     *
     * @throws Exception - stream's error
     */
    public void close() throws Exception {
        fileWriter.close();
    }
}
