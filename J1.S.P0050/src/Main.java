
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
        GetInput input = new GetInput();
        CalculatorProgram calculatorProgram = new CalculatorProgram();
        int choice;
        do {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            choice = input.GetLimit("Please choice one option: ", 1, 3);
            switch (choice) {
                case 1:
                    calculatorProgram.Calculate();
                    break;
                case 2:
                    calculatorProgram.calculateBMI();
                    break;
                case 3:
                    System.out.println("Exit Program!!!");
                    System.exit(0);
                    break;
            }
        } while (choice < 3);
    }
}
