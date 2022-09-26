package com.logicbig.example.Product;

public class Product {
    public Product(int price, String productName) {
        this.price = price;
        this.productName = productName;
    }

    private int price;
    private String productName;

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }
}
