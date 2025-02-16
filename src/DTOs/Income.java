package DTOs;

import java.sql.Date;

public class Income {
    private int id;
    private String title;
    private double amount;
    private Date dateEarned;

    public Income(int id, String title, double amount, Date dateEarned) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getAmount() { return amount; }
    public Date getDateEarned() { return dateEarned; }

    @Override
    public String toString() {
        return "Income{" + "id=" + id + ", title=" + title + ", amount=" + amount +
                ", dateEarned=" + dateEarned + '}';
    }
}
