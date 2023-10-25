package org.example;

public class Transaction {

    private String date;
    private static String time;
    private static String description;
    private String vendor;
    private static double amount;

    public Transaction(String date, String time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public static double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static String getDate() {
        return null;
    }

    public static String getVendor() {
        return null;
    }
}