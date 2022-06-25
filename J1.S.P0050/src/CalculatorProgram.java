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

    public double inputNumber() {
        GetInput input = new GetInput();
        double number = input.getNumber("Enter number: ");
        return number;
    }

    public double Calculate() {
        double result = 0;
        GetInput input = new GetInput();
        System.out.println("----- Normal Calculator -----");
        double memory = input.getNumber("Enter number: ");
        while (true) {
            String operator = input.getOperator("Enter Operator: ");
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory:" + memory);
            } else if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory:" + memory);
            } else if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory:" + memory);
            } else if (operator.equalsIgnoreCase("/")) {
                double number = input.getNumber1("Enter number: ");
                memory /= number;
                System.out.println("Memory:" + memory);
            } else if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory:" + memory);
            } else if (operator.equalsIgnoreCase("=")) {
                result = memory;
                System.out.println("Result:" + result);
                break;
            }
        }
        return result;
    }

    public double calculateBMI() {
        GetInput input = new GetInput();
        System.out.println("----- BMI Calculator -----");
        double weight = input.getBMI("Enter Weight(kg): ");
        double height = input.getBMI("Enter Height(cm): ");
        double BMI = (weight * 10000) / (height * height);
        System.out.printf("BMI number: %.2f\n", BMI);
        System.out.print("BMI Status: ");
        if (BMI < 19) {
            System.out.println("Under-standard");
        } else if (BMI >= 19 && BMI < 25) {
            System.out.println("Standard");
        } else if (BMI >= 25 && BMI < 30) {
            System.out.println("Overweight");
        } else if (BMI >= 30 && BMI < 40) {
            System.out.println("Fat - should lose weight");
        } else {
            System.out.println("Very fat - should lose weight immediately");
        }
        return BMI;
    }
}
