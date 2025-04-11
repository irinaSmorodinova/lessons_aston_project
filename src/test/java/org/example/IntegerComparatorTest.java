package org.example;

import org.example.lesson6.IntegerComparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerComparatorTest {

    @Test
    public void testCompare() {
        assertEquals(0, IntegerComparator.compare(5, 5));
        assertTrue(IntegerComparator.compare(3, 5) < 0);
        assertTrue(IntegerComparator.compare(5, 3) > 0);
    }
}