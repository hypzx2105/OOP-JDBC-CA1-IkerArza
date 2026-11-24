# Expense and Income Tracker (Java + JDBC)

A console app in Java that keeps track of your expenses and income in a MySQL database. I made it for the JDBC CA1 in the Object Oriented Programming module in second year at DkIT (February 2025).

## What it does

```
1. List all Expenses
2. Add Expense
3. Delete Expense by ID
4. List all Income
5. Add Income
6. Delete Income by ID
7. Calculate total income & expenses for a month
8. Exit
```

The lists also show the total, and option 7 asks for a month and a year and shows the income, the expenses and what is left for that month.

## How it's built

I used the DAO pattern. Expense and Income in the DTOs folder are plain classes that hold one row each. The interfaces ExpenseDaoInterface and IncomeDaoInterface say what operations exist, and MysqlExpenseDao and Mysql_IncomeDao implement them with JDBC. Every query uses a PreparedStatement, so the values from the user never go straight into the SQL, and the connections are closed with try with resources. The totals are worked out by MySQL with SUM, MONTH and YEAR instead of looping in Java. Any SQL error is wrapped in a DaoException so the menu can show a simple message.

The database settings are read from environment variables in MysqlDao, so there is no password in the code.

## How to run it

You need Java 17 or newer, MySQL and the [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) jar.

First create the database and some sample data with schema.sql:

```
mysql -u root -p < schema.sql
```

Then set your details if they are not the defaults (localhost, user root, no password) and run it:

```
export DB_URL=jdbc:mysql://localhost:3306/expense_tracker
export DB_USER=root
export DB_PASSWORD=yourpassword

javac -d out $(find src -name "*.java")
java -cp "out:mysql-connector-j-9.2.0.jar" Main
```

On Windows use a semicolon instead of the colon in the classpath. In IntelliJ you can add the jar under Project Structure, Libraries.

Iker Arza, DkIT, BSc in Computing in Software Development
