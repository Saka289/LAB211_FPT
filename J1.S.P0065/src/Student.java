/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saka
 */
public class Student {

    private String StudentName;
    private String ClassName;
    private double Math;
    private double Chemistry;
    private double Physical;
    private double avg;
    private char Type;

    public Student(String StudentName, String ClassName, double Math, double Chemistry, double Physical, double avg, char Type) {
        this.StudentName = StudentName;
        this.ClassName = ClassName;
        this.Math = Math;
        this.Chemistry = Chemistry;
        this.Physical = Physical;
        this.avg = avg;
        this.Type = Type;
    }

    public Student() {
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public double getMath() {
        return Math;
    }

    public void setMath(double Math) {
        this.Math = Math;
    }

    public double getChemistry() {
        return Chemistry;
    }

    public void setChemistry(double Chemistry) {
        this.Chemistry = Chemistry;
    }

    public double getPhysical() {
        return Physical;
    }

    public void setPhysical(double Physical) {
        this.Physical = Physical;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public char getType() {
        return Type;
    }

    public void setType(char Type) {
        this.Type = Type;
    }

}
