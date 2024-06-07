package org.example;

import java.util.List;

public class Customer {

    public void viewProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public boolean buyProduct(Product product, int quantity) {
        if (product != null && product.getQuantity() >= quantity) {
            product.sellProduct(quantity);
            System.out.println("\u001B[32m成功购买:  " + quantity + " 件 " + product.getName() + "\u001B[0m");
            return true;
        } else {
            System.out.println("\u001B[31m当前的库存不足以满足你的购买需求！\u001B[0m");
            return false;
        }
    }
}