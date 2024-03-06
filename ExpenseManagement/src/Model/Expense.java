package Model;

public class Expense {
    private int id;
    private double number;
    private String date;
    private String content;

    public Expense(int id, double number, String date, String content) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.content = content;
    }

    public Expense() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
