
import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        ArrayList<Expense> list = new ArrayList<>();
        GetInput input = new GetInput();
        ExpenseProgram expenseProgram = new ExpenseProgram();
        expenseProgram.loadToFile(list);
        int choice;
        do {
            expenseProgram.menu();
            choice = input.getIntLimit("Your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    expenseProgram.addExpense(list);
                    expenseProgram.writeToFile(list);
                    break;
                case 2:
                    expenseProgram.displayAllExpense(list);
                    break;
                case 3:
                    expenseProgram.deleteExpense(list);
                    break;
                case 4:
                    System.out.println("Exit program!!!");
                    System.exit(0);
                    break;
            }
        } while (choice < 4);
    }
}
