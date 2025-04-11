package org.example;

import org.example.lesson6.FactorialCalculator;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FactorialCalculatorTest {

    @Test
    public void testFactorial() {
        assertEquals(FactorialCalculator.factorial(0), 1);
        assertEquals(FactorialCalculator.factorial(1), 1);
        assertEquals(FactorialCalculator.factorial(5), 120);
        assertEquals(FactorialCalculator.factorial(10), 3628800);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegativeNumber() {
        FactorialCalculator.factorial(-1);
    }
}