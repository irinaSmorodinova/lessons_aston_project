package org.example;

import org.example.lesson6.IntegerComparator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class IntegerComparatorTest {

    @Test
    public void testCompare() {
        assertEquals(IntegerComparator.compare(5, 5), 0);
        assertTrue(IntegerComparator.compare(3, 5) < 0);
        assertTrue(IntegerComparator.compare(5, 3) > 0);
    }
}