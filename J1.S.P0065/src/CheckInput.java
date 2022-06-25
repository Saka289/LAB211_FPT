
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
public class CheckInput {

    public double getDouble(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        double input = 0;
        do {
            System.out.print(msg);
            try {
                input = Double.parseDouble(sc.nextLine().trim());
                if (input < 0) {
                    System.out.println(msg + " is greater than equal zero");
                    continue;
                }
                if (input > 10) {
                    System.out.println(msg + " is less than equal ten");
                    continue;
                }
                loop = false;
            } catch (NumberFormatException e) {
                System.out.println("is digit");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public String getString(String msg) {
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
                loop = false;
            } catch (Exception e) {
                System.out.println("Not empty");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public boolean checkYN(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.length() == 1) {
                if (input.equalsIgnoreCase("Y")) {
                    return true;
                } else if (input.equalsIgnoreCase("N")) {
                    return false;
                }
            }
            System.out.println("input again!!!");
        }

    }
}
