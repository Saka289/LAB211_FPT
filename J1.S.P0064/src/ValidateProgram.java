
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
                if (!input.matches("^[0-9_ ]*$")) {
                    throw new Exception();
                } else if (input.isEmpty()) {
                    throw new Exception();
                }
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
                if (!input.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
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
                    throw new Exception();
                }
                if (!date.matches("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$")) {
                    throw new Error();
                }
                dateFormat.setLenient(false);
                dateFormat.parse(date);
                loop = false;
            } catch (Exception e) {
                System.out.println("Invalid date!!!");
                loop = true;
            } catch (Error e) {
                System.out.println("Date to correct format(dd/mm/yyyy)");
            }
        } while (loop);
        return date;
    }
}
