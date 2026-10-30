package com.pluralsight;

public class Product {
    private String sku;
    private String name;
    private double price;
    private String department;

    public String getSku() {
        return sku;
    }

    public Product setSku(String sku) {
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

    public Product(String sku, String name, double price, String department) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }
    @Override
    public String toString(){
        return sku + " | " + name + " - $" + price;

    }
}
