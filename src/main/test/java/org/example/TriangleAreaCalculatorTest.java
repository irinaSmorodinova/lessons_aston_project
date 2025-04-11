package org.example;

import org.example.lesson6.TriangleAreaCalculator;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TriangleAreaCalculatorTest {

    @Test
    public void testCalculateArea() {
        assertEquals(TriangleAreaCalculator.calculateArea(4, 5), 10.0);
        assertEquals(TriangleAreaCalculator.calculateArea(10, 5), 25.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaInvalidInputNegativeBase() {
        TriangleAreaCalculator.calculateArea(-1, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaInvalidInputNegativeHeight() {
        TriangleAreaCalculator.calculateArea(4, -5);
    }
}