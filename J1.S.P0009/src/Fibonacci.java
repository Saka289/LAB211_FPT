/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saka
 */
public class Fibonacci {

    public static void main(String[] args) {
//        boolean test = true;
       boolean test = false;

        System.out.print("The 45 sequence fibonacci: ");

        Fibonacci(60, 1, 0, 1, test);
    }

    public static int Fibonacci(int temp, int number1, int number2, int cnt, boolean test) {
        if (temp < 2) {
            return number2;
        }
        if (test == true) {
            System.out.print("\n" + number2);
            System.out.print(": " + cnt);
        } else {
            System.out.print(number2);
        }
        if (temp == 2) {
            System.out.print("");
        } else if (test == false) {
            System.out.print(", ");
        }
        return Fibonacci(temp - 1, number2, number1 + number2, cnt + 1, test);
    }
}
