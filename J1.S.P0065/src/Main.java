
import java.util.ArrayList;
import java.util.List;

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
        StudentManagement sm = new StudentManagement();
        List<Student> list = new ArrayList<>();
        //Step 1: Create student and averageStudent
        sm.createStudent(list);
        //Step 2: count Percent Type Student
        sm.getPercentTypeStudent(list);
        //Step 3: show on display Student
        sm.displayStudent(list);
        //Step 4: show on display class
        sm.displayClass();
    }
}
