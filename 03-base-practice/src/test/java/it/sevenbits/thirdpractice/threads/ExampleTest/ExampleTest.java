package it.sevenbits.thirdpractice.threads.ExampleTest;

import it.sevenbits.thirdpractice.threads.Example.Example;
import it.sevenbits.thirdpractice.threads.FileReader.FileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ExampleTest {
    private Example example;

    @Before
    public void setUp() {
        this.example = new Example();
    }
    @Test
    public void getLongestLineCharsCountFirstTest () throws IOException {
        FileReader mockFileReader = mock(FileReader.class);
        when(mockFileReader.readLine()).thenReturn("Homework3.txt line 0: Hi everyone")
                                       .thenReturn("Homework3.txt line 1: Hello everyone");
        when(mockFileReader.hasMoreLines()).thenReturn(true).thenReturn(true).thenReturn(false);
        assertEquals("WrongAnswer", 36, example.getLongestLineCharsCount(mockFileReader));
    }
    @Test
    public void getLongestLineCharsCountSecondTest() throws IOException {
        FileReader mockFileReader = mock(FileReader.class);
        when(mockFileReader.readLine()).thenReturn("Homework3.txt line 0: first line")
                                       .thenReturn("Homework3.txt line 1: second line")
                                       .thenReturn("Homework3.txt line 2: third line");
        when(mockFileReader.hasMoreLines()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        assertEquals("WrongAnswer", 33, example.getLongestLineCharsCount(mockFileReader));
    }
}
