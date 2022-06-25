
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
public class DoctorManagement {

    Scanner sc = new Scanner(System.in);
    CheckInput input = new CheckInput();
    ArrayList<Doctor> list = new ArrayList<>();

    public void addDoctor() {
        System.out.println("--------- Add Doctor ----------");
        String Code = input.checkInputCode("Enter code: ", list);
        String Name = input.checkInput("Enter name: ");
        String Specialization = input.checkInput("Enter Specialization: ");
        int Availability = input.getInt("Enter Availability: ");
        Doctor doctor = new Doctor(Code, Name, Specialization, Availability);
        list.add(doctor);
        System.out.println("--Add successful--");
    }

    public void updateDoctor() {
        System.out.println("--------- Update Doctor ----------");
        if (list.isEmpty()) {
            System.out.println("List empty");
        } else {
            String code = input.checkInputCode1("Enter code update: ", list);
            for (Doctor doctor : list) {
                if (doctor.getCode().equalsIgnoreCase(code)) {
                    String Code = input.checkInputCode("Enter code: ", list);
                    String Name = input.checkInput("Enter name: ");
                    String Specialization = input.checkInput("Enter Specialization: ");
                    int Availability = input.getInt("Enter Availability: ");
                    doctor.setCode(Code);
                    doctor.setName(Name);
                    doctor.setSpecialization(Specialization);
                    doctor.setAvailability(Availability);
                    System.out.println("--Update successful--");
                }
            }
        }
    }

    public void deleteDoctor() {
        System.out.println("--------- Delete Doctor -------");
        if (list.isEmpty()) {
            System.out.println("List empty");
        } else {
            String code = input.checkInputCode1("Enter Code: ", list);
            for (Doctor doctor : list) {
                if (doctor.getCode().equalsIgnoreCase(code)) {
                    list.remove(doctor);
                    System.out.println("--Remove successful--");
                    break;
                }
            }
        }
    }

    public void searchDoctor() {
        System.out.println("---------- Search Doctor --------");
        String name = input.checkInputName("Enter text: ", list);
        if (list.isEmpty()) {
            System.out.println("List empty");
        } else {
            System.out.println("--------- Result ------------");
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : list) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }
    }

}
