
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ExpenseProgram {

    public void menu() {
        System.out.println("=======Handy Expense program======");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
    }

    public void addExpense(ArrayList<Expense> list) {
        GetInput input = new GetInput();
        System.out.println("-------- Add an expense--------");
        int Id = 0;
        for (Expense countId : list) {
            Id++;
        }
        int countID = Id + 1;
        String Date = input.getDate();
        Double Amount = input.getDouble("Enter Amount: ");
        String Content = input.getStringContent("Enter Countent: ");
        Expense expense = new Expense(countID, Date, Amount, Content);
        list.add(expense);
        System.out.println("--Add success--");
    }

    public void displayAllExpense(ArrayList<Expense> list) {
        System.out.println("---------Display all expenses------------");
        double sum = 0;
        for (Expense expense : list) {
            sum = sum + expense.getNumber();
        }
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
            for (Expense expense : list) {
                System.out.printf("%-7d%-20s%-20.0f%-20s\n", expense.getID(), expense.getDate(), expense.getNumber(), expense.getContent());
            }
            System.out.printf("Total: %-20.0f\n", sum);
        }
    }

    public void deleteExpense(ArrayList<Expense> list) {
        GetInput input = new GetInput();
        System.out.println("--------Delete an expense------");
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            int ID = input.getID("Enter ID: ", list);
            for (Expense expense : list) {
                if (expense.getID() == ID) {
                    list.remove(expense);
                    for (int i = ID - 1; i < list.size(); i++) {
                        list.get(i).setID(list.get(i).getID() - 1);
                    }
                    System.out.println("Delete an expense successful");
                    break;
                }
            }
        }
    }

    public void writeToFile(ArrayList<Expense> list) throws IOException {
        try {
            File file = new File("text1.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                for (Expense expense : list) {
                    pw.write(expense.toString());
                    pw.println();
                }
                pw.close();
            } finally {
                fw.close();
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("Error!!!");
        }
    }

    public void loadToFile(ArrayList<Expense> list) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("text1.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] s = line.split("[|]");
                int id = Integer.parseInt(s[0].trim());
                String date = s[1].trim();
                double amount = Double.parseDouble(s[2].trim());
                String content = s[3].trim();
                list.add(new Expense(id, date, amount, content));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error!!!");
        } finally {
            if (fileReader != null && bufferedReader != null) {
                try {
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Error!!!");
                }
            }
        }
    }
}
