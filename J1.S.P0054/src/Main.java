
import java.util.ArrayList;

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
        GetInput input = new GetInput();
        ArrayList<Contact> list = new ArrayList<>();
        ContactManagement contactManagement = new ContactManagement();
        int choice;
        list.add(new Contact(1, "Iker Casillas", "Star", "Spain", "1234567890", "Iker", "Casillas"));
        list.add(new Contact(2, "John Terry", "Star", "England", "1234567890", "John", "Terry"));
        list.add(new Contact(3, "Raul Gonzalez", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));
        list.add(new Contact(4, "John Terry", "Star", "England", "1234567890", "John", "Terry"));
        list.add(new Contact(5, "Raul Gonzalez", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));
        do {
            System.out.println("========= Contact program =========");
            System.out.println("1. Add a Contact");
            System.out.println("2. Display all Contact");
            System.out.println("3. Delete a Contact");
            System.out.println("4. Exit");
            choice = input.getIntLimit("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    contactManagement.addContact(list);
                    break;
                case 2:
                    contactManagement.displayContact(list);
                    break;
                case 3:
                    contactManagement.deleteContact(list);
                    break;
                case 4:
                    System.out.println("Exit Program!!!");
                    System.exit(0);
                    break;
            }
        } while (choice < 4);
    }
}
