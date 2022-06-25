
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saka
 */
public class MyFile {

    Scanner sc = new Scanner(System.in);
    GetInput input = new GetInput();

    public int countWordInFile(String fileSource, String word) throws IOException {
        boolean loop = true;
        int count = 0;
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        // Dọc dữ liệu từ file
        do {
            System.out.println("-------- Count Word --------");
            fileSource = input.getStringPath("Enter Path: ");
            word = input.getStringWord("Enter word: ", "^[a-zA-Z0-9_ ]*$");
            try {
                fileInputStream = new FileInputStream(fileSource);
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line = bufferedReader.readLine();
                while (line != null) {
                    String[] s = line.split(" ");
                    for (String countWord : s) {
                        if (countWord.equalsIgnoreCase(word)) {
                            count++;
                        }
                    }
                    line = bufferedReader.readLine();
                }
                System.out.println("Bout: " + count);
                loop = false;
            } catch (FileNotFoundException e) {
                System.out.println("Do not find file!!!");
                loop = true;
            } catch (IOException e) {
                System.out.println("Error!!!");
                loop = true;
            } finally {
                if (fileInputStream != null && bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        fileInputStream.close();
                    } catch (IOException e) {
                        System.out.println("Error!!!");
                        loop = true;
                    }
                }
            }
        } while (loop);
        return count;
    }

    public List<String> getFileNameContainsWordInDirectory1(String source, String word) throws IOException {
        boolean loop = true;
        do {
            int count = 0;
            int count1 = 0;
            System.out.println("-------- Find File By Word --------");
            source = input.getStringPath("Enter path: ");
            word = input.getStringWord("Enter word: ", "^[a-zA-Z0-9_ ]*$");
            System.out.println("------------ File Name ------------");
            try {
                File folder = new File(source);
                File[] listFile = folder.listFiles();
                for (File file : listFile) {
                    if (file.isFile()) {
                        count++;
                        if (findFile(file.getAbsolutePath(), word) != null) {
                            count1++;
                            System.out.println("file name " + file.getName());
                        }
                    }
                }
                if (count1 == 0) {
                    System.out.println("Don't find word in file!!!");
                }
                if (count == 0) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Don't find to file!!!");
                loop = true;
            }
        } while (loop);
        return null;
    }

    public String findFile(String fileSource, String word) throws IOException {
        boolean loop = true;
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        // Dọc dữ liệu từ file
        do {
            try {
                fileInputStream = new FileInputStream(fileSource);
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line = bufferedReader.readLine();
                while (line != null) {
                    String[] s = line.split(" ");
                    for (String countWord : s) {
                        if (countWord.equalsIgnoreCase(word)) {
                            return countWord;
                        }
                    }
                    line = bufferedReader.readLine();
                }
                loop = false;
            } catch (FileNotFoundException e) {
                loop = true;
            } catch (IOException e) {
                loop = true;
            } finally {
                if (fileInputStream != null && bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        fileInputStream.close();
                    } catch (IOException e) {
                        loop = true;
                    }
                }
            }
        } while (loop);
        return null;
    }
}
