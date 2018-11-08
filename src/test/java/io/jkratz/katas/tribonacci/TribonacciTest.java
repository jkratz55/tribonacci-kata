package io.jkratz.katas.tribonacci;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TribonacciTest {

    private Tribonacci tribonacci;

    @Before
    public void setup() throws Exception {
        this.tribonacci = new Tribonacci();
    }

    @After
    public void tearDown() throws Exception {
        this.tribonacci = null;
    }

    @Test
    public void testTribonacci() {
        assertArrayEquals(new int[] {1,1,1,3,5,9,17,31,57,105}, this.tribonacci.calculate(new int[] {1,1,1}, 10));
        assertArrayEquals(new int[] {0,0,1,1,2,4,7,13,24,44}, this.tribonacci.calculate(new int[] {0,0,1}, 10));
        assertArrayEquals(new int[] {0,1,1,2,4,7,13,24,44,81}, this.tribonacci.calculate(new int[] {0,1,1}, 10));
    }

    @Test
    public void testWithZeroN() {
        int[] seed = {0, 1, 1};
        assertArrayEquals(new int[0], this.tribonacci.calculate(seed, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithLessThanThreeStarting() {
        int[] seed = {0, 1};
        this.tribonacci.calculate(seed, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithInvalidNumToCalculate() {
        int[] seed = {0, 1, 1};
        this.tribonacci.calculate(seed, -10);
    }
}
