
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

    public int GetInput(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int input = 0;
        do {
            System.out.printf(msg);
            try {
                input = Integer.parseInt(sc.nextLine().trim());
                if (input < 0) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Values of matrix is digit!!!");
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
