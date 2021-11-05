package it.sevenbits.thirdpractice.threads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

final class Main {
    /**
     *
     * @param args - console arguments
     * @throws IOException - reading exception
     */
    public static void main(final String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream(new File("MyHomeWork.txt"));
        PrintStream printStream = new PrintStream(outputStream);

        printStream.println(Arrays.toString(Files.readAllBytes(Paths.get("Homework3.txt"))));

        final String lastName = "Dolgushin";

        printStream.println(Arrays.toString(lastName.getBytes(StandardCharsets.UTF_8)));

        printStream.close();
    }
    private Main() {};
}
