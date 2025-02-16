package DAOs;

import DTOs.Expense;
import Exceptions.DaoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlExpenseDao extends MysqlDao implements ExpenseDaoInterface {

    @Override
    public List<Expense> findAllExpenses() throws DaoException {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT * FROM expenses";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("expenseID");
                String title = resultSet.getString("title");
                String category = resultSet.getString("category");
                double amount = resultSet.getDouble("amount");
                Date dateIncurred = resultSet.getDate("dateIncurred");

                expenses.add(new Expense(id, title, category, amount, dateIncurred));
            }
        } catch (SQLException e) {
            throw new DaoException("findAllExpenses() " + e.getMessage());
        }
        return expenses;
    }

    @Override
    public void addExpense(String title, String category, double amount, Date date) throws DaoException {
        String query = "INSERT INTO expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, category);
            preparedStatement.setDouble(3, amount);
            preparedStatement.setDate(4, date);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("addExpense() " + e.getMessage());
        }
    }

    @Override
    public void deleteExpense(int id) throws DaoException {
        String query = "DELETE FROM expenses WHERE expenseID = ?";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Expense deleted successfully.");
            } else {
                System.out.println("No expense found with the given ID.");
            }
        } catch (SQLException e) {
            throw new DaoException("deleteExpense() " + e.getMessage());
        }
    }
}

