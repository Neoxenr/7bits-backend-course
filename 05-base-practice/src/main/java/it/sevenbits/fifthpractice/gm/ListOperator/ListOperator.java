package it.sevenbits.fifthpractice.gm.ListOperator;

import java.util.List;

/**
 * Generic class
 */
public class ListOperator {
    /**
     *
     * @param list - input list
     * @param start - position of first element
     * @param end - position of last element
     * @param <T> - parameter
     * @return T - max element in the list
     */
    public <T extends Comparable<T>> T max(final List<T> list, final int start, final int end) {
        T max = list.get(0);
        for (int i = start; i < end; i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    /**
     * Change positions of two elements in generic list
     * @param list - input list
     * @param first - position of first element
     * @param second - position of last element
     * @param <T> - parameter
     */
    public <T> void changeElementsPosition(final List<T> list, final int first, final int second) {
        T buffer = list.get(first);
        list.set(first, list.get(second));
        list.set(second, buffer);
    }
}
