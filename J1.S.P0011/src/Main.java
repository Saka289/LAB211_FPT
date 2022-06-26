
import java.util.HashMap;

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

    public static void main(String[] args) {
        HashMap<String, String> convertTable = new HashMap<>();
        Convert convert = new Convert();
        GetInput input = new GetInput();
        int choice;
        do {
            System.out.println("======== Convert Progammer ========");
            System.out.println("1. Convert from Binary");
            System.out.println("2. Convert from Decimal");
            System.out.println("3. Convert from Hexadecimal");
            System.out.println("4. Exit progammer");
            choice = input.getIntLimit("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    convert.putHashMap(convertTable);
                    convert.convertBinarytOther(convertTable);
                    break;
                case 2:
                    convert.convertDecimaltOther();
                    break;
                case 3:
                    convert.putHashMap(convertTable);
                    convert.convertHexadecimaltOther(convertTable);
                    break;
                case 4:
                    System.out.println("Exit progammer!!!");
                    System.exit(0);
                    break;
            }
        } while (choice < 4);
    }
}
