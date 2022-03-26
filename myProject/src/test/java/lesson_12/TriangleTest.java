package lesson_12;

import org.junit.jupiter.api.*;

import static lesson_12.TriangleSquareCalculation.computeTriangleSquare;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    public void testWithCorrectSides() throws TriangleNotExistException {
        double result = computeTriangleSquare(3, 4, 5);
        assertEquals(6.0, result);
    }

    @Test
    public void testDegenerateTriangle() throws TriangleNotExistException {
        assertThat(computeTriangleSquare(1, 2, 3)).isEqualTo(0);
    }

    @Test
    public void testThrowsAnException() {
        assertThatThrownBy(() -> computeTriangleSquare(0, 3, 4))
                .isInstanceOf(TriangleNotExistException.class)
                .hasMessage("The entered sides do not form a triangle");
    }
}