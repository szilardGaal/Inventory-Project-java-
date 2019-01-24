package com.codecool;

import java.util.List;
import java.util.ArrayList;



public abstract class Store implements StorageCapable {

    private List<CDProduct> cdProducts = new ArrayList<>();
    private List<BookProduct> bookProducts = new ArrayList<>();

    @Override
    public List<Product> getAllProduct() {
        List<Product> allProducts = new ArrayList<>(cdProducts);
        allProducts.addAll(bookProducts);
        return allProducts;
    }

    @Override
    public void storeBookProduct(String name, int price, int pages) {
        bookProducts.add(new BookProduct(name, price, pages));
    }

    @Override
    public void storeCDProduct(String name, int price, int tracks) {
        cdProducts.add(new CDProduct(name, price, tracks));
    }

    protected Product createProduct(String type, String name, int price, int size) {
        if (type.equals("CD")) {
            return new CDProduct(name, price, size);
        }

        if (type.equals("Book")) {
            return new BookProduct(name, price, size);
        }

        else {
            System.out.println("Invalid product type!");
            return null;
        }
    }

    public List<CDProduct> getCDProducts() {
        return cdProducts;
    }

    public List<BookProduct> getBookProducts() {
        return bookProducts;
    }

    public void store(Product product) {
        saveToXml(product);
        storeProduct(product);
    }

    abstract void storeProduct(Product product);

    abstract void saveToXml(Product product);

    abstract List<Product> loadProducts();

}
