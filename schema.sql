CREATE DATABASE IF NOT EXISTS expense_tracker;
USE expense_tracker;

CREATE TABLE IF NOT EXISTS expenses (
    expenseID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    dateIncurred DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS income (
    incomeID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    dateEarned DATE NOT NULL
);

INSERT INTO expenses (title, category, amount, dateIncurred) VALUES
('Weekly shop', 'Groceries', 64.30, '2025-02-03'),
('Bus Leap card top up', 'Transport', 20.00, '2025-02-05'),
('Phone bill', 'Bills', 15.00, '2025-02-10');

INSERT INTO income (title, amount, dateEarned) VALUES
('Part time job', 420.00, '2025-02-07'),
('Part time job', 410.00, '2025-02-14');
