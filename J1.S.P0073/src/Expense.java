
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saka
 */
public class Expense {

    private int ID;
    private String Date;
    private double Number;
    private String Content;

    public Expense() {
    }

    public Expense(int ID, String Date, double Number, String Content) {
        this.ID = ID;
        this.Date = Date;
        this.Number = Number;
        this.Content = Content;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public double getNumber() {
        return Number;
    }

    public void setNumber(double Number) {
        this.Number = Number;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    @Override
    public String toString() {
        return ID + "|" + Date + "|" + Number + "|" + Content;
    }
}
