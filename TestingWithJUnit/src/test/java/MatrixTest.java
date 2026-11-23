import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {
    Matrix matrix1 = new Matrix(new int[][]
            {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
            });

    //for testing matrix1 transposition
    Matrix matrix2 = new Matrix(new int[][]
            {
                    {1, 4, 7},
                    {2, 5, 8},
                    {3, 6, 9},
            });

    //for testing dimensional mismatches with matrix1
    Matrix matrix3 = new Matrix(new int[][]
            {
                    {1, 4, 7},
                    {2, 5, 8},
                    {3, 6, 9},
                    {10,11,12},
            });

    //for testing addition in between matrix1 and matrix2
    Matrix matrix4 = new Matrix(new int[][]
            {
                    {2, 6, 10},
                    {6, 10, 14},
                    {10, 14, 18},
            });

    //for testing multiplication in between matrix1 and matrix2
    Matrix matrix5 = new Matrix(new int[][] {
            {14,32,50},
            {32,77,122},
            {50,122,194},
    });

    @Test
    public void testIsSquare(){
        assertTrue(matrix1.isSquare());
        assertTrue(matrix2.isSquare());
    }

    @Test
    public void testTranspose(){
        assertArrayEquals(matrix1.transpose().getData(), matrix2.getData());
    }

    @Test
    public void testAdditionDimensionMismatch() {
        //matrix1 is 3x3, matrix3 is 4x3 so this throws exception, and our test succeeds
        assertThrows(IllegalArgumentException.class, () -> matrix1.add(matrix3));
    }

    @Test
    public void testMultiplicationDimensionMismatch(){
        //matrix1's column dimension 3, matrix3's row dimension 4 so this fail; it throws Exception and because of that test succeeds
        assertThrows(IllegalArgumentException.class, () -> matrix1.multiply(matrix3));
    }

    @Test
    public void testAddition(){
        assertArrayEquals(matrix1.add(matrix2).getData(), matrix4.getData());
    }

    @Test
    public void testMultiplication(){
        assertArrayEquals(matrix1.multiply(matrix2).getData(), matrix5.getData());
    }


}
