package com.codecool;

public class BookProduct extends Product {

    private int numOfPages;

    public BookProduct(String name, int price, int numOfPages) {
        this.name = name;
        this.price = price;
        this.numOfPages = numOfPages;
    }

    @Override
    public int getSize() {
        return numOfPages;
    }

    @Override
    public String toString() {
        return "Book";
    }
}
