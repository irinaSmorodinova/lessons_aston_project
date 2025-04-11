package org.example;


import org.example.lesson6.FactorialCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {

    @Test
    public void testFactorial() {
        assertEquals(1, FactorialCalculator.factorial(0));
        assertEquals(1, FactorialCalculator.factorial(1));
        assertEquals(120, FactorialCalculator.factorial(5));
        assertEquals(3628800, FactorialCalculator.factorial(10));
    }

    @Test
    public void testFactorialNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-1));
    }
}