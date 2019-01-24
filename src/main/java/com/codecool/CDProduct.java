package com.codecool;

public class CDProduct extends Product {

    private int numOfTracks;

    public CDProduct(String name, int price, int numOfTracks) {
        this.name = name;
        this.price = price;
        this.numOfTracks = numOfTracks;
    }

    @Override
    public int getSize() {
        return numOfTracks;
    }

    @Override
    public String toString() {
        return "CD";
    }
}
