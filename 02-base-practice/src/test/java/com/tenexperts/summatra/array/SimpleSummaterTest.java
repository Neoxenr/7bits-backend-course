package com.tenexperts.summatra.array;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class SimpleSummaterTest {
    private SimpleSummater simpleSummater;
    @Before
    public void setUp() {
        this.simpleSummater = new SimpleSummater();
    }
    @Test
    public void testSumFirst() {
        int[] testCase = {0, -14, 18, 35, 122, 5};
        assertEquals("Wrong answer", 166, simpleSummater.sum(testCase));
    }
    @Test
    public void testSumSecond() {
        int[] testCase = {-19, 18, -20, 23, 24};
        assertEquals("Wrong answer", 26, simpleSummater.sum(testCase));
    }
    @Test
    public void testSumThird() {
        int[] testCase = {12, 14, -18, 98};
        assertEquals("Wrong answer", 106, simpleSummater.sum(testCase));
    }
}
