package org.example;

import org.example.lesson6.TriangleAreaCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaCalculatorTest {

    @Test
    public void testCalculateArea() {
        assertEquals(10.0, TriangleAreaCalculator.calculateArea(4, 5));
        assertEquals(25.0, TriangleAreaCalculator.calculateArea(10, 5));
    }

    @Test
    public void testCalculateAreaInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.calculateArea(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.calculateArea(4, -5));
    }
}