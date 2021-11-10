package it.sevenbits.thirdpractice.threads.FileReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileReaderTest {
    private FileReader fileReader;

    @Before
    public void setUp() throws IOException {
        this.fileReader = new FileReader(new File("Homework3.txt"));
    }

    @Test
    public void fileReaderReadLineTest() throws IOException {
        Assert.assertEquals("Wrong answer", "Homework3.txt line 0: А ларчик просто открывался", fileReader.readLine());
    }
}
