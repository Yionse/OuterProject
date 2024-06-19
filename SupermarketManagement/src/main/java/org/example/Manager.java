package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Manager {

    private List<Product> productsList;

    //  当初始化时，需要从文件中读取出商品内容
    Manager() {
        List<Product> products = new ArrayList<Product>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Products.csv", StandardCharsets.UTF_8))) {
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                // 跳过表头
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // 解析每一行数据
                String[] fields = line.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int sales = Integer.parseInt(fields[2]);
                int quantity = Integer.parseInt(fields[3]);

                // 创建Product对象并添加到列表中
                Product product = new Product(name, price, sales, quantity);
                products.add(product);
            }
            System.out.println("商品初始化成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    //  同步Product到本地文件，这样可以永久保存。每次只要对Product进行操作了，都需要调用这个函数进行同步。
    public void synchronizationProduct() {
        // CSV文件的路径
        String csvFile = "Products.csv";

        // 定义CSV文件的表头
        String[] header = {"商品名称", "价格", "销量", "库存"};

        // 使用FileWriter和BufferedWriter写入CSV文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, StandardCharsets.UTF_8))) {
            // 写入表头
            for (int i = 0; i < header.length; i++) {
                writer.write(header[i]);
                if (i < header.length - 1) {
                    writer.write(",");
                }
            }
            writer.newLine();

            // 写入数据行
            for (int i = 0; i < this.productsList.size(); i++) {
                Product product = this.productsList.get(i);
                writer.write(product.getName() + "," + product.getPrice() + "," + product.getSalesQuantity() + "," + product.getQuantity());
                writer.newLine();
            }

            System.out.println("CSV文件写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}