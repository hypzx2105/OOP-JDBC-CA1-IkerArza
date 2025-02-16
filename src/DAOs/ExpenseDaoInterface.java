package DAOs;

import DTOs.Expense;
import Exceptions.DaoException;
import java.sql.Date;
import java.util.List;

public interface ExpenseDaoInterface {
    List<Expense> findAllExpenses() throws DaoException;
    void addExpense(String title, String category, double amount, Date date) throws DaoException;
    void deleteExpense(int id) throws DaoException;
    double getTotalExpenses() throws DaoException;
    double getExpensesForMonth(int month, int year) throws DaoException;

}
