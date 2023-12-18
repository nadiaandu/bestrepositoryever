package org.example;

public class CustoHistory {
    private String productName;
    private int total;

    public CustoHistory(String productName, int total) {
        this.productName = productName;
        this.total = total;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
