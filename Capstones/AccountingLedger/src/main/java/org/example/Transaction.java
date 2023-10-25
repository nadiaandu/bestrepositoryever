package org.example;

public class Transaction {

    private String date;
    private String type;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(String date, String type, String description, String vendor, double amount) {
        this.date = date;
        this.type = type;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}