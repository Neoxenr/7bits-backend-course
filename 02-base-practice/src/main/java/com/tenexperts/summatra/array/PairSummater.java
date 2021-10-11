package com.tenexperts.summatra.array;

/**
 * IArraySummater implementation
 */
public class PairSummater implements IArraySummater {
    /**
     *
     * @param numbers - input array which consist of int numbers
     * @return int - maximum sum in array's pairs
     * @throws ArraySummaterException - if array's length is not even
     */
    public int sum(final int [] numbers) throws ArraySummaterException {
        if (numbers.length % 2 == 0) {
            int max = 0;
            for (int i = 0; i < numbers.length - 1; i += 2) {
                if (numbers[i] + numbers[i + 1] > max) {
                    max = numbers[i] + numbers[i + 1];
                }
            }
            return max;
        } else {
            throw new ArraySummaterException("Array's length must be even");
        }
    }
}
