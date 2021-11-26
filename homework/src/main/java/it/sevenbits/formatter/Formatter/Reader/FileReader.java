package it.sevenbits.formatter.Formatter.Reader;

import it.sevenbits.formatter.Formatter.Exceptions.ReadException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class FileReader implements IReader, AutoCloseable {
    private final Reader fileReader;

    /**
     *
     * @param path - file path
     * @throws FileNotFoundException - if file isn't founded
     */
    public FileReader(final String path) throws FileNotFoundException {
        fileReader = new InputStreamReader(new FileInputStream(new File(path)), StandardCharsets.UTF_8);
    }


    /**
     *
     * @return char - symbol from stream
     * @throws ReadException - if all symbols are read
     * @throws IOException - stream's exception
     */
    public char read() throws ReadException, IOException {
        if (!hasNext()) {
            throw new ReadException("Error of file's reading");
        }
        return (char) fileReader.read();
    }

    /**
     *
     * @return boolean - if reading a stream hasn't ended yet
     * @throws IOException - stream's error
     */
    public boolean hasNext() throws IOException {
        return fileReader.ready();
    }

    /**
     *
     * @throws IOException - stream's error
     */
    public void close() throws IOException {
        fileReader.close();
    }
}
