package com.codecool;

public abstract class Product {

    protected String name;
    protected int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract int getSize();
}
