package DAOs;

import DTOs.Expense;
import Exceptions.DaoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlExpenseDao extends MysqlDao implements ExpenseDaoInterface {

    @Override
    public List<Expense> findAllExpenses() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Expense> expenseList = new ArrayList<>();

        try {
            connection = this.getConnection();
            String query = "SELECT * FROM expenses";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("expenseID");
                String title = resultSet.getString("title");
                String category = resultSet.getString("category");
                double amount = resultSet.getDouble("amount");
                Date dateIncurred = resultSet.getDate("dateIncurred");

                Expense expense = new Expense(id, title, category, amount, dateIncurred);
                expenseList.add(expense);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllExpenses() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) freeConnection(connection);
            } catch (SQLException e) {
                throw new DaoException("findAllExpenses() " + e.getMessage());
            }
        }
        return expenseList;
    }

    @Override
    public void addExpense(String title, String category, double amount, Date date) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.getConnection();
            String query = "INSERT INTO expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, category);
            preparedStatement.setDouble(3, amount);
            preparedStatement.setDate(4, date);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("addExpense() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) freeConnection(connection);
            } catch (SQLException e) {
                throw new DaoException("addExpense() " + e.getMessage());
            }
        }
    }
}

