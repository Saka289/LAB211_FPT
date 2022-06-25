
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lê Nam
 */
public class BubbleSoft {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = checkInPut("Enter number of array:\n", sc);
//        int[] a = inputArray(n);
//        boolean test = false;
        boolean test = true;
        int[] a = {5, 1, 12, -5, 16};// test case

        Display("Unsorted array: ", a);
        BubbleSort(a, test);
        Display("Sorter array: ", a);

    }

    public static int checkInPut(String msg, Scanner sc) {
        boolean loop = true;
        int n = 0;
        do {
            System.out.print(msg);
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n <= 0) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Enter again");
                loop = true;
            }

        } while (loop);
        return n;
    }

    public static int[] inputArray(int n) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n);
        }
        return a;
    }

    public static void Display(String msg, int[] a) {
        System.out.print(msg);
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(", ");
            }
        }
        if (msg.equals("Unsorted array: ")) {
            System.out.println("]");
        } else {
            System.out.print("]");
        }
    }

    private static void BubbleSort(int[] array, boolean test) {
        /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < array.length; i++) {
            /*Loop use to accessed first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < array.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (array[j] > array[j + 1]) {
                    //Display each step in sorting process in test case
                    if (test == true) {
                        Display("", array);
                        System.out.println("    " + array[j] + ">" + array[j + 1] + ", " + "swap");//test algorithm
                    }
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else if (test == true) { //Display each step in sorting process in test case
                    Display("", array);//testalgorithm
                    System.out.println("    " + array[j] + "<" + array[j + 1] + ", " + "ok");
                }
            }
        }
    }

}
