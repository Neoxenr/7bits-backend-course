package it.sevenbits.thirdworkshop.FileChecker;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;

public class FileChecker {
    private final int stringsLimit = 5;

    private int stringsCounter;

    private final Writer writer;

    /**
     * FileChecker initializing
     * @param fileName - new file name
     */
    public FileChecker(final String fileName) throws IOException {
        writer = Files.newBufferedWriter(Paths.get(fileName));
        stringsCounter = 0;
    }

    /**
     * Writing information about directory in a file
     * @param directoryName - name of directory where will be searching information
     */
    public void write(final String directoryName) throws IOException {
        Files.walkFileTree(Paths.get(directoryName), new FileVisitor<Path>() {
            private final String string = "File name: %s | File type: %s | Access truth: %s | Absolute path: %s\n";

            @Override
            public FileVisitResult preVisitDirectory(final Path path, final BasicFileAttributes basicFileAttributes) throws IOException {
                writer.write(String.format(string, path.getFileName(), "directory",
                        PosixFilePermissions.toString(Files.getPosixFilePermissions(path)), path));
                if (++stringsCounter == stringsLimit) {
                    writer.flush();
                    stringsCounter = 0;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(final Path path, final BasicFileAttributes basicFileAttributes) throws IOException {
                writer.write(String.format(string, path.getFileName(), "file",
                        PosixFilePermissions.toString(Files.getPosixFilePermissions(path)), path));
                if (++stringsCounter == stringsLimit) {
                    writer.flush();
                    stringsCounter = 0;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(final Path path, final IOException e) throws IOException {
                writer.write("ERROR\n");
                if (++stringsCounter == stringsLimit) {
                    writer.flush();
                    stringsCounter = 0;
                }
                return FileVisitResult.SKIP_SUBTREE;
            }

            @Override
            public FileVisitResult postVisitDirectory(final Path path, final IOException e) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
        writer.close();
    }
}