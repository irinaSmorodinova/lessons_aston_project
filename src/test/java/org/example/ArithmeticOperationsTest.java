package org.example;


import org.example.lesson6.ArithmeticOperations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTest {

    @Test
    public void testAdd() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
        assertEquals(-1, ArithmeticOperations.add(-2, 1));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, ArithmeticOperations.subtract(3, 2));
        assertEquals(-3, ArithmeticOperations.subtract(-2, 1));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, ArithmeticOperations.multiply(2, 3));
        assertEquals(-2, ArithmeticOperations.multiply(-2, 1));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, ArithmeticOperations.divide(4, 2));
        assertEquals(-2.0, ArithmeticOperations.divide(-4, 2));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> ArithmeticOperations.divide(4, 0));
    }
}