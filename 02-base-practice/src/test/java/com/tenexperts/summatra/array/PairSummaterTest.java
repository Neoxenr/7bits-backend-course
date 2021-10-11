package com.tenexperts.summatra.array;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PairSummaterTest {
    private PairSummater pairSummater;
    @Before
    public void setUp() {
        this.pairSummater = new PairSummater();
    }
    @Test
    public void testMaxPairSumFirst() throws ArraySummaterException {
        int[] testCase = {-14, 15, 33, 75};
        assertEquals("Wrong answer", 108, pairSummater.sum(testCase));
    }
    @Test
    public void testMaxPairSumSecond() throws ArraySummaterException {
        int[] testCase = {0, -18, 14, -9, 16, -23};
        assertEquals("Wrong answer", 5, pairSummater.sum(testCase));
    }
    @Test
    public void testMaxPairSumThird() throws ArraySummaterException {
        int[] testCase = {-84, 5, 21, 16, -14, 67, -65, 32};
        assertEquals("Wrong answer", 53, pairSummater.sum(testCase));
    }
    @Test(expected = ArraySummaterException.class)
    public void testMaxPairSumException() throws ArraySummaterException {
        pairSummater.sum(new int[] {13, -31, 34});
    }
}
