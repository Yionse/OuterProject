package org.example;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static private ArrayList<Product> productList = new ArrayList<Product>();
    static private Manager managerController = new Manager(productList);      //  超市管理者对象
    static private Customer customer = new Customer();     //  顾客对象
    public static void main(String[] args) {
        init();     //  初始化商品
        menu();     //  显示菜单，接收用户输入
    }

    static public void init() {
        //  初始化一些商品
        Product product = new Product(
                "可口可乐", 100,  3
        );
        Product product1 = new Product(
                "优酸乳", 10,  2.5
        );
        managerController.addProduct(product);
        managerController.addProduct(product1);
    }

    static public void menu() {
        Scanner input = new Scanner(System.in);
        Integer type = -99;
        System.out.println("\u001B[34m欢迎使用超市商品管理系统！\u001B[0m");
        System.out.println("1：进入管理员模式");
        System.out.println("2：进入顾客模式");
        System.out.println("0：退出");
        while (!(type.equals(1) || type.equals(2) || type.equals(3) || type.equals(0))) {
            System.out.println("\u001B[32m请输入：\u001B[0m");
            type = input.nextInt();
        }
        switch (type) {
            case 1 : {
                System.out.println("\u001B[33m欢迎进入超市管理界面！\u001B[0m");
                managerMenu();
                break;
            }
            case 2 : {
                System.out.println("\u001B[33m欢迎进入超市购物界面！\u001B[0m");
                customerMenu();
                break;
            }
            default: {
                System.out.println("\u001B[31m即将退出，谢谢使用！\u001B[0m");
            } break;
        }
    }

    //  管理员操作
    static public void managerMenu() {
        Scanner scanner = new Scanner(System.in);
        int type ;
        System.out.println("1：查看商品列表");
        System.out.println("2：添加商品");
        System.out.println("3：删除商品");
        System.out.println("4：补充商品库存");
        System.out.println("5：查看销售额");
        System.out.println("\u001B[32m请输入(-1退出管理员模式)：\u001B[0m");
        type = scanner.nextInt();
        boolean valid = false;
        while (!valid) {
            if (type == 1 || type == 2 || type == 3 || type == 3 || type == 4 || type == 5) {
                valid = true;
                switch (type) {
                    case 1: {
                        productMenu();
                        managerMenu();
                        break;
                    }
                    case 2: addProduct(); break;
                    case 3: delProduct(); break;
                    case 4: updateStock(); break;
                    case 5: showPrice(); break;
                }
            }else if (type == -1) {
                valid = true;
                menu();
            }else {
                System.out.println("\u001B[31m输入的操作编号无效，请重新输入(-1退出管理员模式)：\u001B[0m");
            }
        }
    }

    //  顾客操作
    static public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        int productId;   //  购买的商品
        List<Product> products = managerController.getProductsList();
        productMenu();
        System.out.println("\u001B[32m请输入要购买的商品编号(-1退出顾客模式)：\u001B[0m");
        productId = scanner.nextInt();
        boolean validInput = false; // 标记输入是否有效

        while (!validInput) { // 如果输入无效，循环将继续
            if (productId >= 0 && productId < products.size()) {
                // 如果编号在列表范围内，输入有效
                validInput = true;
                // 获取用户想要购买的数量
                System.out.println("\u001B[34m请输入要购买的数量(-1退出顾客模式)：\u001B[0m");
                int num = scanner.nextInt();
                boolean validInputNum = false;
                while (!validInputNum) {
                    //  数量大于0
                    if (num > 0) {
                        //  可以正常购买
                        if ( products.get(productId).getQuantity() >= num) {
                            validInputNum = true;
                            customer.buyProduct(products.get(productId), num);
                            productMenu();
                            System.out.println("\u001B[32m请输入要购买的商品编号(-1退出顾客模式)：\u001B[0m");
                            validInput = false;
                            productId = scanner.nextInt();
                        //  数量不足
                        }else {
                            System.out.println("\u001B[31m抱歉库存不足，已通知补货！：\u001B[0m");
                            System.out.println("\u001B[31m请重新选择商品！\u001B[0m");
                            productMenu();
                            validInput = false;
                            validInputNum = true;
                            System.out.println("\u001B[32m请输入要购买的商品编号(-1退出顾客模式)：\u001B[0m");
                            productId = scanner.nextInt();
                        }

                    }else if (num == -1) {
                        menu();
                    }else {
                        //  不符合购买条件
                        System.out.println("\u001B[31m输入的商品数量无效，请重新输入(-1退出顾客模式)：\u001B[0m");
                        num = scanner.nextInt();
                    }
                }
            } else if (productId == -1) {
                validInput = true;
                menu();
            } else {
                // 如果编号不在列表范围内，提示用户重新输入
                System.out.println("\u001B[31m输入的商品编号无效，请重新输入(-1退出顾客模式)：\u001B[0m");
                productId = scanner.nextInt(); // 用户重新输入商品编号
            }
        }
    }

    //  商品的列表
    static public void productMenu() {
        System.out.println("\n编号\t\t品名\t\t\t\t\t\t\t单价\t\t\t\t\t\t\t库存\t\t\t\t\t\t\t已售");
        List<Product> products = managerController.getProductsList();
        for (Integer i = 0; i < products.size(); i++) {
            System.out.println(i + "\t\t" + products.get(i).showProductInfo());
        }
        System.out.println("\n");
    }

    //  添加商品
    static public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        String productName;
        double price;
        int stock;
        System.out.println("\u001B[32m请输入商品名称：\u001B[0m");
        productName = scanner.nextLine();
        System.out.println("\u001B[32m请输入商品单价：\u001B[0m");
        price = scanner.nextDouble();
        System.out.println("\u001B[32m请输入商品库存：\u001B[0m");
        stock = scanner.nextInt();
        Product product = new Product(productName, stock, price);
        managerController.addProduct(product);
        System.out.println("\u001B[32m商品添加成功！\u001B[0m");
        managerMenu();
    }

    //  删除商品
    static public void delProduct() {
        productMenu();
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int num;
        System.out.println("\u001B[32m请输入要删除的商品编号(-1退出管理员模式)：\u001B[0m");
        num = scanner.nextInt();
        while (!valid) {
            if (num >= 0 && num < managerController.getProductsList().size()) {
                managerController.deleteProduct(managerController.getProductsList().get(num));
                System.out.println("\u001B[31m删除成功！\u001B[0m");
                productMenu();
                managerMenu();
                valid = true;
            }else if (num == -1) {
                menu();
                valid = true;
            }else {
                System.out.println("\u001B[31m输入的商品编号无效，请重新输入(-1退出管理员模式)：\u001B[0m");
                num = scanner.nextInt();
            }
        }
    }

    //  修改库存
    static public void updateStock() {
        productMenu();
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int num;
        System.out.println("\u001B[32m请输入要添加库存的商品编号(-1退出管理员模式)：\u001B[0m");
        num = scanner.nextInt();
        while (!valid) {
            if (num >= 0 && num < managerController.getProductsList().size()) {
                boolean validStock = false;
                int addCount;
                System.out.println("\u001B[32m请输入添加数量(-1退出管理员模式)：\u001B[0m");
                addCount = scanner.nextInt();
                while (!validStock) {
                    if (addCount > 0) {
                        managerController.getProductsList().get(num).restockProduct(addCount);
                        System.out.println("\u001B[32m成功添加商品库存！\u001B[0m");
                        productMenu();
                        managerMenu();
                        validStock=true;
                    } else if (addCount == -1) {
                        menu();
                        validStock = true;
                    } else {
                        System.out.println("\u001B[31m输入的数量无效，请重新输入(-1退出管理员模式)：\u001B[0m");
                        addCount = scanner.nextInt();
                    }
                }
                productMenu();
                managerMenu();
                valid = true;
            }else if (num == -1) {
                menu();
                valid = true;
            }else {
                System.out.println("\u001B[31m输入的商品编号无效，请重新输入(-1退出管理员模式)：\u001B[0m");
                num = scanner.nextInt();
            }
        }
    }

    //  查看销售额
    static public void showPrice() {
        System.out.println("\n销售情况如下");
        System.out.println("编号\t\t品名\t\t\t\t\t\t\t单价\t\t\t\t\t\t\t库存\t\t\t\t\t\t\t已售\t\t\t\t\t\t\t销售额");
        double total = 0;
        List<Product> products = managerController.getProductsList();
        for (Integer i = 0; i < products.size(); i++) {
            Product product =  products.get(i);
            total += product.getPrice() * product.getSalesQuantity();
            System.out.println(i + "\t\t" + product.showProductInfo() + "\t\t\t\t\t\t\t" + product.getPrice() * product.getSalesQuantity());
        }
        System.out.println("\u001B[32m总销售额为：" + total + "\n\u001B[0m");
        managerMenu();
    }
}