package it.sevenbits.thirdpractice.threads.FileReaderTest;

import it.sevenbits.thirdpractice.threads.FileReader.FileReader;
import org.junit.*;

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
        Assert.assertEquals("Wrong answer", "Homework3.txt line 0: ./" ,  fileReader.readLine());
    }
}
