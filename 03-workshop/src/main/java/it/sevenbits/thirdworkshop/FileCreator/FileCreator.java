package it.sevenbits.thirdworkshop.FileCreator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCreator {
    private final File file;

    /**
     *
     * @param newFileName - Name of new file
     */
    public FileCreator(final String newFileName) {
        file = new File(newFileName);
    }

    /**
     *
     * @param directoryPath - directory path
     * @throws IOException - if file will be not found
     */
    public void write(final String directoryPath) throws IOException {
        int stringsReadCounter = 0;

        final int stringLimit = 5;

        File directory = new File(directoryPath);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);

        for (Path path : Files.newDirectoryStream(directory.toPath())) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("File name: ").append(path.getFileName().toString()).append(" | File type: ").
                    append(path.toFile().isDirectory() ? "directory" : "file").append(" | ").append("Access truth: ").
                    append((path.toFile().canRead() ? 'r' : '-')).append((path.toFile().canWrite() ? 'w' : '-')).
                    append((path.toFile().canExecute() ? 'x' : '-')).append(" | Absolute path: ").append(path.toFile().getAbsolutePath()).append('\n');

            writer.write(stringBuilder.toString());

            if (++stringsReadCounter == stringLimit) {
                writer.flush();
                stringsReadCounter = 0;
            }
        }
        writer.close();
    }
}
