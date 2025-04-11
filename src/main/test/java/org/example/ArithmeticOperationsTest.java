package org.example;

import org.example.lesson6.ArithmeticOperations;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ArithmeticOperationsTest {

    @Test
    public void testAdd() {
        assertEquals(ArithmeticOperations.add(2, 3), 5);
        assertEquals(ArithmeticOperations.add(-2, 1), -1);
    }

    @Test
    public void testSubtract() {
        assertEquals(ArithmeticOperations.subtract(3, 2), 1);
        assertEquals(ArithmeticOperations.subtract(-2, 1), -3);
    }

    @Test
    public void testMultiply() {
        assertEquals(ArithmeticOperations.multiply(2, 3), 6);
        assertEquals(ArithmeticOperations.multiply(-2, 1), -2);
    }

    @Test
    public void testDivide() {
        assertEquals(ArithmeticOperations.divide(4, 2), 2.0);
        assertEquals(ArithmeticOperations.divide(-4, 2), -2.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(4, 0);
    }
}