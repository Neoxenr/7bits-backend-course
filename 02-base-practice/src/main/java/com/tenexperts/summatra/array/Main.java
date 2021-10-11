package com.tenexperts.summatra.array;

/**
 * Main application entry point
 */
public final class Main {
    /**
     * Main function for app
     * @param string - console arguments
     */
    public static void main(final String[] string) {
        final int[] numbers = {-44, 35, -22, 11, 55};
        SimpleSummater simpleSummater = new SimpleSummater();
        System.out.println(simpleSummater.sum(numbers));
    }
    private Main() {}
}
