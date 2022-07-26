
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saka
 */
public class StudentManagement {

    public void createStudent(List<Student> list) {
        CheckInput input = new CheckInput();
        System.out.println("====== Management Student Program ======");
        while (true) {
            String StudentName = input.getString("Name: ");
            String ClassName = input.getString("Classes: ");
            double Math = input.getDouble("Maths: ");
            double Chemistry = input.getDouble("Chemistry: ");
            double Physical = input.getDouble("Physics: ");
            double Avg = averageStudent(Math, Chemistry, Physical);
            char Type;
            if (Avg > 7.5) {
                Type = 'A';
            } else if (Avg >= 6 && Avg <= 7.5) {
                Type = 'B';
            } else if (Avg >= 4 && Avg < 6) {
                Type = 'C';
            } else {
                Type = 'D';
            }
            Student student = new Student(StudentName, ClassName, Math, Chemistry, Physical, Avg, Type);
            list.add(student);
            if (!input.checkYN("Do you want to enter more student information?(Y/N): ")) {
                return;
            }
        }
    }

    public double averageStudent(double x, double y, double z) {
        double Avg = (x + y + z) / 3;
        return Avg;
    }

    public HashMap<String, Double> getPercentTypeStudent(List<Student> list) {
        HashMap<String, Double> map = new HashMap<>();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int total = list.size();
        for (Student listStudent : list) {
            if (listStudent.getType() == 'A') {
                countA++;
            } else if (listStudent.getType() == 'B') {
                countB++;
            } else if (listStudent.getType() == 'C') {
                countC++;
            } else {
                countD++;
            }
        }
        map.put("A", 100.0 * countA / total);
        map.put("B", 100.0 * countB / total);
        map.put("C", 100.0 * countC / total);
        map.put("D", 100.0 * countD / total);
        return map;
    }

    public void displayStudent(List<Student> list) {
        int count = 0;
        for (Student student : list) {
            System.out.println("------ Student" + ++count + " Info ------");
            System.out.println("Name: " + student.getStudentName());
            System.out.println("Classes: " + student.getClassName());
            System.out.printf("AVG: %.1f\n", student.getAvg());
            System.out.println("Type: " + student.getType());
        }
    }

    public void displayClass(List<Student> list) {
        HashMap<String, Double> getPercentTypeStudent = getPercentTypeStudent(list);
        Set<Map.Entry<String, Double>> setHashMap = getPercentTypeStudent.entrySet();
        System.out.println("--------Classification Info -----");
        for (Map.Entry<String, Double> classes : setHashMap) {
            System.out.print(classes.getKey() + ":");
            System.out.printf(" %.1f", classes.getValue());
            System.out.println("%");
        }
    }
}
