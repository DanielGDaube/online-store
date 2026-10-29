package com.pluralsight;

public class Product {
    private int sku;
    private String name;
    private double price;
    private String department;

    public int getSku() {
        return sku;
    }

    public Product setSku(int sku) {
        this.sku = sku;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Product setDepartment(String department) {
        this.department = department;
        return this;
    }

    public Product(int sku, String name, double price, String department) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }
}
