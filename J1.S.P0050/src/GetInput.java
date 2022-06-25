
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saka
 */
public class GetInput {

    public double getNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        double input = 0;
        do {
            System.out.print(msg);
            try {
                input = Double.parseDouble(sc.nextLine().trim());
                if (input < 0) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Input again!!!");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public double getNumber1(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        double input = 0;
        do {
            System.out.print(msg);
            try {
                input = Double.parseDouble(sc.nextLine().trim());
                if (input < 0) {
                    throw new Exception();
                }
                if (input == 0) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Input again!!!");
                loop = true;
            } catch (Error e) {
                System.out.println("Math Error!!!");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public double getBMI(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        double input = 0;
        do {
            System.out.print(msg);
            try {
                input = Double.parseDouble(sc.nextLine().trim());
                if (input < 0) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("BMI is digit");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public String getOperator(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String input = "";
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new Exception();
                }
                if (input.equalsIgnoreCase("+") || input.equalsIgnoreCase("-")
                        || input.equalsIgnoreCase("*") || input.equalsIgnoreCase("/")
                        || input.equalsIgnoreCase("^") || input.equalsIgnoreCase("=")) {
                    loop = false;
                } else {
                    throw new Error();
                }
            } catch (Exception e) {
                System.out.println("Operator is not empty");
                loop = true;
            } catch (Error e) {
                System.out.println("Please input (+ , -, *, /, ^)");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public int GetLimit(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int input = 0;
        do {
            System.out.print(msg);
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Input again!!!");
                loop = true;
            }
        } while (loop);
        return input;
    }
}
