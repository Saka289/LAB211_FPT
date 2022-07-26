
import java.util.ArrayList;
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
public class GetInput {

    //[0-9] must be number from 0 to 9
    //{10} must be 10 digits
    private static final String PHONE_VALID_0 = "[0-9]{10}";

    //[0-9] must be number from 0 to 9
    //{3} must be 3 digits
    //{4} must be 4 digits
    //[-] must contain character - 
    private static final String PHONE_VALID_1 = "[0-9]{3}[-][0-9]{3}[-][0-9]{4}";

    //[0-9] must be number from 0 to 9
    //{3} must be 3 digits
    //{4} must be 4 digits
    //[.] must contain character .
    private static final String PHONE_VALID_2 = "[0-9]{3}[.][0-9]{3}[.][0-9]{4}";

    //[0-9] must be number from 0 to 9
    //{3} must be 3 digits
    //{4} must be 4 digits
    //[ ] must contain character " "
    private static final String PHONE_VALID_3 = "[0-9]{3}[ ][0-9]{3}[ ][0-9]{4}";

    //[0-9] must be number from 0 to 9
    //{3} must be 3 digits
    //{4} must be 4 digits
    //[-] must contain character -
    //[ ] must contain character " "
    //[a-z0-9] contain number and aphabet 
    //+ characters can repeat 1 or more times
    private static final String PHONE_VALID_4 = "[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ ][a-z0-9]+";

    //[0-9] must be number from 0 to 9
    //{3} must be 3 digits
    //{4} must be 4 digits
    //[-] must contain character -
    //[(] must contain character (
    //[)] must contain character )
    private static final String PHONE_VALID_5 = "[(][0-9]{3}[)][-][0-9]{3}[-][0-9]{4}";

    public String getName(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String input = "";
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new Error();
                }
                if (!input.matches("(\\b[a-zA-Z]{1}[a-z]+)( )([a-zA-Z]{1}[a-z]+\\b)")) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Input again!!!");
                loop = true;
            } catch (Error e) {
                System.out.println("Not empty!!!");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String input = "";
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Input again!!!");
                loop = true;
            } catch (Error e) {
                System.out.println("Not empty!!!");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public String getPhone(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String input = "";
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new Error();
                }
                if (!input.matches(PHONE_VALID_0) && !input.matches(PHONE_VALID_1) && !input.matches(PHONE_VALID_2)
                        && !input.matches(PHONE_VALID_3) && !input.matches(PHONE_VALID_4) && !input.matches(PHONE_VALID_5)) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Please input Phone flow\n"
                        + "• 1234567890\n"
                        + "• 123-456-7890 \n"
                        + "• 123-456-7890 x1234\n"
                        + "• 123-456-7890 ext1234\n"
                        + "• (123)-456-7890\n"
                        + "• 123.456.7890\n"
                        + "• 123 456 7890");
                loop = true;
            } catch (Error e) {
                System.out.println("Phone is not empty!!!");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public int getID(String msg, ArrayList<Contact> list) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int input = 0;
        do {
            System.out.print(msg);
            try {
                input = Integer.parseInt(sc.nextLine().trim());
                if (input <= 0) {
                    throw new Exception();
                }
                int count = 0;
                for (Contact contact : list) {
                    if (contact.getContactId() == input) {
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("ID is digit");
            } catch (Error e) {
                System.out.println("Delete a contact fail");
            }
        } while (loop);
        return input;
    }

    public int getIntLimit(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int input = 0;
        do {
            System.out.print(msg);
            try {
                input = Integer.parseInt(sc.nextLine().trim());
                if (input < min || input > max) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Input must be integer !!!");
                loop = true;
            }
        } while (loop);
        return input;
    }

}
