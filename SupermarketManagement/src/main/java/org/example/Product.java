
package org.example;
import java.util.Date;

public class Product {
    private String name;
    private int quantity; // 商品数量
    private int salesQuantity; // 销售数量
    private double price; // 单价

    // Constructor
    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.salesQuantity = 0; // 初始化销售数量为0
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // 商品售出
    public boolean sellProduct(int quantitySold) {
        if (quantitySold <= quantity) {
            this.quantity -= quantitySold;
            this.salesQuantity += quantitySold;
            return true;
        } else {
            System.out.println("该商品库存不够啦！" + name);
            return false;
        }
    }

    // 进货
    public void restockProduct(int additionalQuantity) {
        this.quantity += additionalQuantity;
    }

    // 输出商品信息
    public String showProductInfo() {
        return name + "\t\t\t\t\t\t" + price + "\t\t\t\t\t\t\t" +  quantity + "\t\t\t\t\t\t\t" + salesQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}