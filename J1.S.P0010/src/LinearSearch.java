
import java.util.Random;
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
public class LinearSearch {

    public static void main(String[] args) {
        //Step 1: Enter number of array
        int size_array = checkInput("Enter number of array: ");
        //Step 2: Enter search value
        int value = checkInput("Enter search value: ");
        //Step 3: Random array follow size_array
        int[] array = randomArray(size_array);
        //Step 4: Show on display the array random
        Display("The array: ", array);
        //Step 5: find index follow value and idisplay on srceen the index
        linearSearch("Found " + value + " at index: ", value, array);
    }

    public static int checkInput(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int input = 0;
        do {
            System.out.println(msg);
            try {
                input = Integer.parseInt(sc.nextLine().trim());
                if (input <= 0) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Input a positive decimal number !!!");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public static int[] randomArray(int size_array) {
        Random rd = new Random();
        int[] array = new int[size_array];
        for (int i = 0; i < size_array; i++) {
            array[i] = rd.nextInt(size_array);
        }
        return array;
    }

    public static void Display(String msg, int[] array) {
        System.out.print(msg);
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void linearSearch(String msg, int value, int[] array) {
        int count = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == value) {
                System.out.print(msg);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
                if (count == 1) {
                    System.out.print(i);
                } else {
                    System.out.print(", " + i);
                }
            } else if (i == array.length - 1 && count == 0) {
                System.out.print("Can't found value!!!");
            }
        }
    }

}
