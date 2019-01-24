package com.codecool;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PersistentStore theStore = new PersistentStore();
        StoreManager manager = new StoreManager();
        manager.addStorage(theStore);

        List<Product> products = theStore.loadProducts();
        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getPrice() + " " + product.getSize() + " " + product.toString());
        }

        theStore.store(new CDProduct("cucc", 3000, 12));
        theStore.store(new CDProduct("lö lemez", 2010, 9));
        theStore.store(new BookProduct("a könyv", 3001, 345));
        theStore.store(new BookProduct("másik cucc", 431, 455));

        for (Product product : theStore.getAllProduct()) {
            System.out.println(product.getName());
        }

        for (CDProduct cd : theStore.getCDProducts()) {
            System.out.println(cd.getName());
        }

        for (BookProduct book : theStore.getBookProducts()) {
            System.out.println(book.getName());
        }


    }
}
