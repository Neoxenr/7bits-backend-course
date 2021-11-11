package it.sevenbits.thirdpractice.threads.FileReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class FileReader {
    private final List<String> strings;
    private final String fileName;
    private int stringCounter = 0;

    /**
     * @param file - input thread
     * @throws IOException - reading exception
     */
    public FileReader(final File file) throws IOException {
        strings = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        fileName = file.getName();
    }

    /**
     * @return String - file's name and string's number and string
     * @throws IOException - if nothing read
     */
    public String readLine() throws IOException {
        if (!hasMoreLines()) {
            throw new IOException("Reading's file error");
        }
        return fileName + " line " + stringCounter + ": " + strings.get(stringCounter++);
    }

    /**
     * @return boolean - true, if file hasn't ended yet
     */
    public boolean hasMoreLines() {
        return stringCounter < strings.size();
    }
}