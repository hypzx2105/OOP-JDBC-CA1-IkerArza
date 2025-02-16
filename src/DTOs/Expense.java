package DTOs;

import java.sql.Date;

public class Expense {
    private int id;
    private String title;
    private String category;
    private double amount;
    private Date dateIncurred;

    public Expense(int id, String title, String category, double amount, Date dateIncurred) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public Date getDateIncurred() { return dateIncurred; }

    @Override
    public String toString() {
        return "Expense{" + "id=" + id + ", title=" + title + ", category=" + category +
                ", amount=" + amount + ", dateIncurred=" + dateIncurred + '}';
    }
}
