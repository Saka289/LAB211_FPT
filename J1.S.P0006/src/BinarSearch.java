
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
public class BinarSearch {

    public static void main(String[] args) {
//        int input = getInput("Enter number of array: ");
//        boolean test = false;
//
//        int[] radomArray = randomArray(input);
        boolean test = true;
        int[] radomArray = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};

        int value = getInput("Enter search value: ");

        BubbleSort(radomArray);

        displayArray("Sorted array: ", radomArray);

        displayBinarySearch(radomArray, value, test);
    }

    public static int getInput(String msg) {
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
                System.out.println("Input again!!!");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public static int[] randomArray(int input) {
        Random random = new Random();
        int[] array = new int[input];
        for (int i = 0; i < input; i++) {
            array[i] = random.nextInt(input);
        }
        return array;
    }

    public static void displayArray(String msg, int[] array) {
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

    public static void BubbleSort(int[] array) {
        /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < array.length; i++) {
            /*Loop use to accessed first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < array.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int BinarySearch(int array[], int value, boolean test) {
        int left = 0;
        int right = array.length - 1;
        int i = 0;
        int count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //Check if x is present at mid
            if (array[mid] == value) {
                count++;
                if (test == true) {
                    System.out.print("Step " + ++i + " (middle element is " + array[mid] + "=" + value + "): ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] < array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.print("{" + array[mid] + "} ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] > array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.println();
                }
                return mid;
            }
            // If x greater, ignore left half
            if (array[mid] < value) {
                if (test == true) {
                    System.out.print("Step " + ++i + " (middle element is " + array[mid] + "<" + value + "): ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] < array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.print("{" + array[mid] + "} ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] > array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.println();
                }
                left = mid + 1;
                // If x is smaller, ignore right half
            } else {
                if (test == true) {
                    System.out.print("Step " + ++i + " (middle element is " + array[mid] + ">" + value + "): ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] < array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.print("{" + array[mid] + "} ");
                    for (int j = 0; j < array.length; j++) {
                        if (array[j] > array[mid]) {
                            System.out.print(array[j] + " ");
                        }
                    }
                    System.out.println();
                }
                right = mid - 1;
            }
        }
        if (count == 0 && test == true) {
            System.out.print("Step " + ++i + " (searched value is absent): ");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
        }
        return -1;
    }

    public static void displayBinarySearch(int[] array, int value, boolean test) {
        int result = BinarySearch(array, value, test);
        if (result == -1 && test == false) {
            System.out.println("Can't found value!!!");
        } else if (test == false) {
            System.out.println("Found " + value + " at index: " + result);
        }
    }
}
