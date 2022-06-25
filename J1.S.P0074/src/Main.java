/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saka
 */
public class Main {

    public static void main(String[] args) {
        CalculatorProgram calculatorProgram = new CalculatorProgram();
        GetInput input = new GetInput();
        int[][] matrix1, matrix2, result;
        int choice;
        do {
            System.out.println("======== Calculator Program ========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplcation Matrix");
            System.out.println("4. Quit");
            choice = input.GetLimit("Your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("-------- Addition --------");
                    matrix1 = calculatorProgram.getMatrix1();
                    matrix2 = calculatorProgram.getMatrix2(matrix1, choice);
                    result = calculatorProgram.additionMatrix(matrix1, matrix2);
                    calculatorProgram.displayResult(matrix1, matrix2, result, choice);
                    break;
                case 2:
                    System.out.println("-------- Subtraction --------");
                    matrix1 = calculatorProgram.getMatrix1();
                    matrix2 = calculatorProgram.getMatrix2(matrix1, choice);
                    result = calculatorProgram.subtractionMatrix(matrix1, matrix2);
                    calculatorProgram.displayResult(matrix1, matrix2, result, choice);
                    break;
                case 3:
                    System.out.println("-------- Multiplcation --------");
                    matrix1 = calculatorProgram.getMatrix1();
                    matrix2 = calculatorProgram.getMatrix2(matrix1, choice);
                    result = calculatorProgram.multiplicationMatrix(matrix1, matrix2);
                    calculatorProgram.displayResult(matrix1, matrix2, result, choice);
                    break;
                case 4:
                    System.out.println("Exit program!!!");
                    System.exit(0);
                    break;
            }
        } while (choice < 4);
    }
}
