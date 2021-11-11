package it.sevenbits.thirdpractice.threads;

import java.io.*;
import java.nio.charset.StandardCharsets;

final class Main {
    /**
     * @param args - console arguments
     * @throws IOException - reading exception
     */
    public static void main(final String[] args) throws IOException {
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream("Homework3.txt"));
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("MyHomeWork.txt"))) {
            final int bufferLength = 100;

            byte[] buffer = new byte[bufferLength];

            outputStream.write(buffer, 0, inputStream.read(buffer));
            outputStream.write('\n');

            final String lastName = "Долгушин";

            InputStream byteArrayInputStream = new ByteArrayInputStream(lastName.getBytes(StandardCharsets.UTF_8));

            while (byteArrayInputStream.available() > 0) {
                outputStream.write(byteArrayInputStream.read());
            }
        }
    }

    private Main() {
    }

    ;
}
