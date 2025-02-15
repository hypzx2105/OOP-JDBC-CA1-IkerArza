import DAOs.MysqlExpenseDao;
import DAOs.ExpenseDaoInterface;
import DTOs.Expense;
import Exceptions.DaoException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseDaoInterface expenseDao = new MysqlExpenseDao();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("\nAll Expenses:");
            List<Expense> expenses = expenseDao.findAllExpenses();
            if (expenses.isEmpty()) {
                System.out.println("No expenses found.");
            } else {
                for (Expense expense : expenses) {
                    System.out.println(expense);
                }
            }

            System.out.println("\nEnter a new expense:");
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();
            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            System.out.print("Date (YYYY-MM-DD): ");
            Date date = Date.valueOf(scanner.next());

            expenseDao.addExpense(title, category, amount, date);
            System.out.println("Expense added successfully.");

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
