/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package MatrixCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mai
 */
public class CalculatorIT {
    private Calculator cal;
    
    public CalculatorIT() {
        cal = new Calculator();
    }

    @Test
    public void testAdditionMatrix() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{7, 8, 9}, {10, 11, 12}};
        int[][] expected = {{8, 10, 12}, {14, 16, 18}};

        int[][] result = cal.additionMatrix(matrix1, matrix2);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSubtractionMatrix() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{7, 8, 9}, {10, 11, 12}};
        int[][] expected = {{-6, -6, -6}, {-6, -6, -6}};

        int[][] result = cal.subtractionMatrix(matrix1, matrix2);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testMultiplicationMatrix() {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};
        int[][] expected = {{19, 22}, {43, 50}};

        int[][] result = cal.multiplicationMatrix(matrix1, matrix2);

        assertArrayEquals(expected, result);
    }
    
}
