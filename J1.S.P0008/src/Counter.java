
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saka
 */
public class Counter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Step 1: Enter your String
        String n = getString("Enter your content: ", "^[a-zA-Z0-9_ ]*$");
        //Step 2: Function count number letterts
        CounterLetter(n);
        //Step 3: Function count number characters
        CounterCharacters(n);

    }

    // Function check input String
    public static String getString(String msg, String regex) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String input = "";
        do {
            System.out.println(msg);
            try {
                input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new Exception();
                }
                if (!input.matches(regex)) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Content not empty!!!");
                loop = true;
            } catch (Error e) {
                System.out.println("Error format!!!");
            }
        } while (loop);
        return input;
    }

    // Function count number 
    public static void CounterLetter(String Input) {
        HashMap<String, Integer> letters = new HashMap<>();
        StringTokenizer st = new StringTokenizer(Input);
        // Count letterrs
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (letters.containsKey(word)) {
                letters.put(word, letters.get(word) + 1);
            } else {
                letters.put(word, 1);
            }
        }
        System.out.println(letters);
    }

    public static void CounterCharacters(String Input) {
        HashMap<Character, Integer> characters = new HashMap<>();
        // Count Characters
        String s = Input.replace(" ", "");
        char[] ch = s.toCharArray();
        for (char word : ch) {
            if (characters.containsKey(word)) {
                characters.put(word, characters.get(word) + 1);
            } else {
                characters.put(word, 1);
            }
        }
        System.out.println(characters);
    }
}