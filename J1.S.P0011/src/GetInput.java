
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

    public String getInputBinary(String msg) {
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
                if (!input.matches("[0-1]*")) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("is digit");
                loop = true;
            } catch (Error e) {
                System.out.println("Error format");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public String getInputDecimal(String msg) {
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
                if (!input.matches("[0-9]*")) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("is digit");
                loop = true;
            } catch (Error e) {
                System.out.println("Error format");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public String getInputHexadecimal(String msg) {
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
                if (!input.matches("[0-9A-F]*")) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("is digit");
                loop = true;
            } catch (Error e) {
                System.out.println("Error format");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public int getIntLimit(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int input = 0;
        do {
            System.out.print(msg);
            try {
                input = Integer.parseInt(sc.nextLine().trim());
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
