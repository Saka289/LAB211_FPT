
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
public class ContactManagement {

    public void addContact(ArrayList<Contact> list) {
        GetInput input = new GetInput();
        System.out.println("-------- Add a Contact --------");
        int countId = 0;
        for (Contact contact : list) {
            countId++;
        }
        int contactId = countId + 1;
        String fullName = input.getName("Enter Name: ");
        String group = input.getString("Enter Group: ");
        String address = input.getString("Enter Address: ");
        String phone = input.getPhone("Enter Phone: ");
        String[] s = fullName.split(" ");
        String lastName = s[0].trim();
        String firstName = s[1].trim();
        list.add(new Contact(contactId, fullName, group, address, phone, lastName, firstName));
        System.out.println("Successful");
    }

    public void displayContact(ArrayList<Contact> list) {
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        if (list.isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            System.out.printf("%-5s%-15s%-15s%-15s%-10s%-10s%-10s\n", "Id", "Name", "First name", "Last name", "Group", "Address", "Phone");
            for (Contact contact : list) {
                System.out.printf("%-5d%-15s%-15s%-15s%-10s%-10s%-10s\n",
                        contact.getContactId(), contact.getFullName(),
                        contact.getLastName(), contact.getFirstName(),
                        contact.getGroup(), contact.getAddress(), contact.getPhone());
            }
        }
    }

    public void deleteContact(ArrayList<Contact> list) {
        GetInput input = new GetInput();
        System.out.println("------- Delete a Contact -------");
        if (list.isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            int ID = input.getID("Enter ID: ", list);
            for (Contact contact : list) {
                if (contact.getContactId() == ID) {
                    list.remove(contact);
                    for (int i = ID - 1; i < list.size(); i++) {
                        list.get(i).setContactId(list.get(i).getContactId() - 1);
                    }
                    System.out.println("Successful");
                    break;
                }
            }
        }
    }
}
