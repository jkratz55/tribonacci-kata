package io.jkratz.katas.tribonacci;

public class Tribonacci {

    /**
     * Produces a tribonacci sequence of numbers based on a seed up the n places.
     *
     * @param seed The seed to calculate the tribonacci sequence. Example: [0,1,1]
     * @param n The number of places to calculate
     * @return
     */
    public int[] calculate(int[] seed, int n) {

        // If n is a negative number throw exception, cannot calculate negative count of tribonacci values
        if (n < 0) {
            throw new IllegalArgumentException("n must be an integer value 0 or greater");
        }

        // If n is zero there are no values to calculate, simply return an empty array
        if (n == 0) {
            return new int[0];
        }

        // If the seed does not contain exactly three values throw an exception, as the seed should always
        // contain 3 numbers
        if (seed.length != 3) {
            throw new IllegalArgumentException("seed must be an array of integers with exactly three values");
        }

        // Create a new array and copy the seed values
        int[] result = new int[n];
        result[0] = seed[0];
        result[1] = seed[1];
        result[2] = seed[2];

        // Calculate the max position to iterate to
        int max = n - 3;

        // Build the sequence aka fill in the array
        for (int i=0; i < max; i++) {
            // Sum the last three values to get the next value and set the value
            int newVal = result[i] + result[i + 1] + result[i + 2];
            result[i + 3] = newVal;
        }

        return result;
    }
}
