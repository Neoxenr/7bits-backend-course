package com.tenexperts.summatra.array;

import com.tenexperts.summatra.array.IArraySummater;

/**
 * IArraySummater implementation
 */
public class SimpleSummater implements IArraySummater {
    /**
     *
     * @param numbers - input array which consist of int numbers
     * @return int - sum of all array's elements
     */
    public int sum(final int [] numbers) {
        int count = 0;
        for (int number : numbers) {
            count += number;
        }
        return count;
    }
}
