/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saka
 */
public class CalculatorProgram {

    public int[][] getMatrix1() {
        GetInput input = new GetInput();
        int row = input.GetInput("Enter Row Matrix 1: ");
        int col = input.GetInput("Enter Column Matrix 1: ");
        int[][] matrix1 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                String msg = String.format("Enter Matrix1" + "[%d][%d]:", i + 1, j + 1);
                matrix1[i][j] = input.GetInput(msg);
            }
        }
        return matrix1;
    }

    public int[][] getMatrix2(int[][] matrix1, int choice) {
        GetInput input = new GetInput();
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2, col2;
        if (choice == 1 || choice == 2) {
            do {
                row2 = input.GetInput("Enter Row Matrix 2: ");
                if (row2 != row1) {
                    System.out.println("The two matrices must be of the same size!!!");
                    continue;
                } else {
                    break;
                }
            } while (true);

            do {
                col2 = input.GetInput("Enter Column Matrix 2: ");
                if (col2 != col1) {
                    System.out.println("The two matrices must be of the same size!!!");
                    continue;
                } else {
                    break;
                }
            } while (true);
        } else {
            do {
                row2 = input.GetInput("Enter Row Matrix 2: ");
                if (row2 != col1) {
                    System.out.println("The number of columns of the matrix1 is ​​equal to the number of rows of the matrix2!!!");
                    continue;
                }
                col2 = input.GetInput("Enter Column Matrix 2: ");
                break;
            } while (true);
        }
        int[][] matrix2 = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                String msg = String.format("Enter Matrix2" + "[%d][%d]:", i + 1, j + 1);
                matrix2[i][j] = input.GetInput(msg);
            }
        }
        return matrix2;
    }

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, int choice) {
        System.out.println("-------- Result ---------");
        displayMatrix(matrix1);
        switch (choice) {
            case 1:
                System.out.println("+");
                break;
            case 2:
                System.out.println("-");
                break;
            case 3:
                System.out.println("x");
                break;
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

}
