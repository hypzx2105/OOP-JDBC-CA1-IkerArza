import DAOs.MysqlExpenseDao;
import DAOs.Mysql_IncomeDao;
import DAOs.ExpenseDaoInterface;
import DAOs.IncomeDaoInterface;
import DTOs.Expense;
import DTOs.Income;
import Exceptions.DaoException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseDaoInterface expenseDao = new MysqlExpenseDao();
        IncomeDaoInterface incomeDao = new Mysql_IncomeDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. List all Expenses");
            System.out.println("2. Add Expense");
            System.out.println("3. Delete Expense by ID");
            System.out.println("4. List all Income");
            System.out.println("5. Add Income");
            System.out.println("6. Delete Income by ID");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                if (choice == 1) {
                    List<Expense> expenses = expenseDao.findAllExpenses();
                    for (Expense expense : expenses) System.out.println(expense);
                } else if (choice == 2) {
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
                } else if (choice == 3) {
                    System.out.print("Enter Expense ID to delete: ");
                    int id = scanner.nextInt();
                    expenseDao.deleteExpense(id);
                } else if (choice == 4) {
                    List<Income> incomes = incomeDao.findAllIncome();
                    for (Income income : incomes) System.out.println(income);
                } else if (choice == 5) {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Date (YYYY-MM-DD): ");
                    Date date = Date.valueOf(scanner.next());

                    incomeDao.addIncome(title, amount, date);
                    System.out.println("Income added successfully.");
                } else if (choice == 6) {
                    System.out.print("Enter Income ID to delete: ");
                    int id = scanner.nextInt();
                    incomeDao.deleteIncome(id);
                } else {
                    break;
                }
            } catch (DaoException e) {
                System.out.println("An error occurred: " + e.getMessage());

            }
        }
    }
}
