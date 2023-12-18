package org.example;

public class Main {
    public static void main(String[] args) {
        CategoryRepository cr = new CategoryRepository("jdbc:mysql://localhost:3306/northwind", args[0], args[1]);

        Category category = new Category(0, "Bougie Woogie", "For the bougies");
       // Category category2 = new Category(10, "Bougie Woogie", "For the bougies");


       // cr.createCategory(category);
        cr.updateCategory(category);

        CustoHistoryRepository chr = new CustoHistoryRepository("jdbc:mysql://localhost:3306/northwind", args[0], args[1]);
        var histories = chr.getCustomerHistory("ANATR");
        for(CustoHistory custoHistory : histories){
            System.out.println("product name: " + custoHistory.getProductName() + "" + custoHistory.getTotal());
        }
    }
}