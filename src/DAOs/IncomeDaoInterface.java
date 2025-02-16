package DAOs;

import DTOs.Income;
import Exceptions.DaoException;
import java.sql.Date;
import java.util.List;

public interface IncomeDaoInterface {
    List<Income> findAllIncome() throws DaoException;
    void addIncome(String title, double amount, Date date) throws DaoException;
    void deleteIncome(int id) throws DaoException;
    double getTotalIncome() throws DaoException;
    double getIncomeForMonth(int month, int year) throws DaoException;
}
