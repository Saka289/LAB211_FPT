
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
//        int n = checkInput("Enter number of array:\n");
//        int[] a = inputArray(n);
//        boolean test = false;
        boolean test = true;
        int[] a = {5, 1, 12, -5, 16, 2, 12, 14};
        Display("Unsorted array: ", a);
        Sort(a, test);
        Display("Sorted array: ", a);
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

    public static void Sort(int a[], boolean test) {
        //loop pass through each elements from beginning to before the last index of array 
        for (int i = 0; i < a.length - 1; i++) {
            int min_index = i;
            //loop pass through each elements from i+1 to end of array 
            for (int j = i + 1; j < a.length; j++) {
                //compare each pair of elements
                if (a[j] < a[min_index]) {
                    min_index = j;
                }
            }
            //function test selection sort algorithm
            if (test == true && a[min_index] < a[i]) {
                Display("", a);
                System.out.println("\t" + a[i] + " swap " + a[min_index]);
            } else if (test == true) {
                Display("", a);
                System.out.println("\t" + a[i] + ", " + "OK");
            }
            //Swap the find minimum element with the first element
            int temp = a[min_index];
            a[min_index] = a[i];
            a[i] = temp;
        }
    }
}
