package it.sevenbits.workshop.matrix;

import java.util.Random;

public class Matrix {
    private final int CELL_MAX_VALUE = 100;

    private Cell[][] matrix;

    private Matrix() {
    }

    public Matrix(int rowsCount, int columnsCount) {
        matrix = new Cell[rowsCount][columnsCount];
        fillMatrixByRandomValues();
    }

    private void fillMatrixByRandomValues() {
        Random rand = new Random();

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                int cellValue = rand.nextInt(CELL_MAX_VALUE);
                Cell newCell = new Cell(x, y, cellValue);
                matrix[x][y] = newCell;
            }
        }
    }

    public void inverseMatrix() {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                matrix[x][y].inverse();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                sb.append(matrix[x][y].getValue()).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
