
import java.text.SimpleDateFormat;
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
public class ValidateProgram {

    public static void main(String[] args) {
        System.out.println("====== Validate Progaram ======");
        String phoneNumber = getPhone("Phone number: ");
        String email = getEmail("Email: ");
        String date = getDate("Date: ");
    }

    public static String getPhone(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String input = "";
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine().trim();
                //regex; ^ start of input string, 
                //[0-9] must number from 0 to 9, 
                //$ end of input string, 
                //* previous character can be repeated
                if (!input.matches("^[0-9]*$")) {
                    throw new Exception();
                } else if (input.isEmpty()) {
                    throw new Exception();
                }
                //regex; ^ start of input string, 
                //[0-9] must number from 0 to 9, 
                //$ end of input string,
                //{10} must be 10 digíts
                if (!input.matches("^[0-9]{10}$")) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Phone number must is digits");
                loop = true;
            } catch (Error e) {
                System.out.println("Phone number must be 10 digits");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public static String getEmail(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String input = "";
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine().trim();
                //^ start of input string,
                //[\\w} contain any word character (alphanumeric and underscore)
                //\\. contain character .
                //@ must contain character @
                //{2, 4} from 2 to 4 characters
                //$ end of input string,
                if (!input.matches("^[\\w]+@([\\w]+\\.)+[\\w]{2,4}$")) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Email must is correct format");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public static String getDate(String msg) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        boolean loop = true;
        String date = "";
        do {
            System.out.print(msg);
            try {
                date = sc.nextLine();
                if (date.isEmpty()) {
                    System.out.println("Date not empty!!!");
                    continue;
                }
                //^ start of input string,
                //? characters can repeat 0 or 1 times
                //[0-3] must number from 0 to 3,
                //[0-9] must number from 0 to 9, 
                // / must contain character /
                //{2} must be 2 digíts
                //$ end of input string,
                if (!date.matches("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$")) {
                    throw new Error();
                }
                dateFormat.setLenient(false);
                dateFormat.parse(date);
                loop = false;
            } catch (Exception e) {
                System.out.println("date does not exist!!!");
                loop = true;
            } catch (Error e) {
                System.out.println("Date to correct format(dd/mm/yyyy)");
            }
        } while (loop);
        return date;
    }
}
