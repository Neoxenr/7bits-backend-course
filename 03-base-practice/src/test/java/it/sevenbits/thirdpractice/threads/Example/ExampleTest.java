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

    @Test
    public void getLongestLineCharsCountEmptyTest() throws IOException {
        FileReader mockFileReader = mock(FileReader.class);
        when(mockFileReader.hasMoreLines()).thenReturn(false);
        assertEquals("WrongAnswer", 0, example.getLongestLineCharsCount(mockFileReader));
    }

    @Test
    public void getLongestLineCharsCountStandardTest() throws IOException {
        FileReader mockFileReader = mock(FileReader.class);
        when(mockFileReader.readLine()).thenReturn("Homework3.txt line 0: first line")
                .thenReturn("HomeworkTest.txt line 1: second line")
                .thenReturn("HomeworkTest.txt line 2: third line");
        when(mockFileReader.hasMoreLines()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        assertEquals("WrongAnswer", 33, example.getLongestLineCharsCount(mockFileReader));
    }
}
