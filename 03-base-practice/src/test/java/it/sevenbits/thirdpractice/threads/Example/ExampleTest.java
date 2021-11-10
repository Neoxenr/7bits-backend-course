package it.sevenbits.thirdpractice.threads.Example;

import it.sevenbits.thirdpractice.threads.FileReader.FileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExampleTest {
    private Example example;

    @Before
    public void setUp() {
        this.example = new Example();
    }

    @Test(expected = IOException.class)
    public void readLineExceptionTest() throws IOException {
        FileReader mockFileReader = mock(FileReader.class);
        when(mockFileReader.readLine()).thenReturn("HomeworkTest.txt line 0: Hi everyone").thenThrow(IOException.class);
        mockFileReader.readLine();
        mockFileReader.readLine();
    }

    @Test
    public void getLongestLineCharsCountSecondTest() throws IOException {
        FileReader mockFileReader = mock(FileReader.class);
        when(mockFileReader.readLine()).thenReturn("Homework3.txt line 0: first line")
                .thenReturn("HomeworkTest.txt line 1: second line")
                .thenReturn("HomeworkTest.txt line 2: third line");
        when(mockFileReader.hasMoreLines()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        assertEquals("WrongAnswer", 33, example.getLongestLineCharsCount(mockFileReader));
    }
}
