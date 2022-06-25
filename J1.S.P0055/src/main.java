
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
public class main {

    public static void main(String[] args) {
        DoctorManagement doctorManagement = new DoctorManagement();
        CheckInput input = new CheckInput();
        int choice;
        do {
            System.out.println("========= Doctor Management ==========");
            System.out.println("\t1. Add Doctor: ");
            System.out.println("\t2. Update Doctor: ");
            System.out.println("\t3. Delete Doctor: ");
            System.out.println("\t4. Search Doctor: ");
            System.out.println("\t5. Exit");
            choice = input.getInt("Enter number(1-5): ", 1, 5);
            switch (choice) {
                case 1:
                    doctorManagement.addDoctor();
                    break;
                case 2:
                    doctorManagement.updateDoctor();
                    break;
                case 3:
                    doctorManagement.deleteDoctor();
                    break;
                case 4:
                    doctorManagement.searchDoctor();
                    break;
                case 5:
                    System.out.println("--Exit Doctor Management--");
                    System.exit(0);
                    break;
            }
        } while (choice < 5);
    }
}
