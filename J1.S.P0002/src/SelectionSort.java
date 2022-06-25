
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
public class SelectionSort {

    public static void main(String[] args) {
        int n = checkInput("Enter number of array:\n");
        int[] a = inputArray(n);
        Display("Unsorted array: ", a);
        Sort(a);
        Display("\nSorted array: ", a);
    }

    public static int checkInput(String msg) {
        Scanner sc = new Scanner(System.in);
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
                loop = true;
            }

        } while (loop);
        return n;
    }

    public static int[] inputArray(int n) {
        Random random = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n);
        }
        return a;
    }

    public static void Display(String msg, int a[]) {
        System.out.print(msg);
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    
    public static void Sort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
}
