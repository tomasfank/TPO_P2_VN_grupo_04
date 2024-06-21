package org.example.exercises.ejercicio5MonteCarlo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.example.classes.R2Point;

public class R2PointTest {

    @Test
    public void testGetX() {
        R2Point point = new R2Point(3.0, 4.0);
        assertEquals(3.0, point.getX(), 0.001);
    }

    @Test
    public void testGetY() {
        R2Point point = new R2Point(3.0, 4.0);
        assertEquals(4.0, point.getY(), 0.001);
    }

    @Test
    public void testPrint() {
        R2Point point = new R2Point(3.0, 4.0);
        // To test the print method, we can redirect the standard output and verify the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        point.print();
        assertEquals("(3.0, 4.0)\n", outContent.toString());
    }
}

