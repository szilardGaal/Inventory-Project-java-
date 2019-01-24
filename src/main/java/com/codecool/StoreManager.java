package com.codecool;

public class StoreManager {

    StorageCapable storage;


    public void addStorage(StorageCapable storage) {
        this.storage = storage;
    }

    public void addCDProduct(String name, int price, int tracks) {
        storage.storeCDProduct(name, price, tracks);
    }

    public void addBookPRoduct(String name, int price, int pages) {
        storage.storeBookProduct(name, price, pages);
    }

    public String listProducts() {
        String storageElements = "";
        int counter = 1;
        for (Product product : storage.getAllProduct()) {
            storageElements += counter + " " + product.getName() + "\n";
            counter++;
        }
        return storageElements;
    }

    public int getTotalProductPrice() {
        int sum = 0;
        for (Product product : storage.getAllProduct()) {
            sum += product.getPrice();
        }
        return sum;
    }
}


