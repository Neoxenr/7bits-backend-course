package com.tenexperts.summatra.array;

import com.tenexperts.summatra.array.ArraySummaterException;

/**
 * Interface with 1 virtual method
 */
public interface IArraySummater {
    /**
     *
     * @param numbers - input array which consist of int numbers
     * @return int - some sum
     * @throws ArraySummaterException - exception
     */
    int sum(int[] numbers) throws ArraySummaterException;
}
