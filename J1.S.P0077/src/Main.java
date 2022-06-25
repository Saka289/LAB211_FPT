
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saka
 */
public class Main {
    public static void main(String[] args) throws IOException {
        GetInput input = new GetInput();
        MyFile myfile = new MyFile();
        int choice;
        String path = null;
        String word = null;
        do{
            System.out.println("============ Word Program =========");
            System.out.println("1. Count Word In File");
            System.out.println("2. Find File By Word");
            System.out.println("3. Exit");
            choice = input.getIntLimit("Your choice: ", 1, 3);
            switch (choice) {
                case 1:
                    myfile.countWordInFile(path, word);
                    break;
                case 2:
                    myfile.getFileNameContainsWordInDirectory1(path, word);
                    break;
                case 3:
                    System.out.println("Exit program!!!");
                    System.exit(0);
                    break;
            }
        }while (choice < 3);
    }
}
