package org.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Manager {

    private List<Product> productsList;

    Manager(List<Product> products) {
        this.productsList = products;
    }

    public void addProduct(Product product) {
        productsList.add(product);
        System.out.println("成功添加商品：: " + product.getName());
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    //  删除该product
    public void deleteProduct(Product product) {
        productsList.remove(product);
    }

}