package com.codecool;

import java.util.List;
import java.util.ArrayList;

public interface StorageCapable {

    List<Product> getAllProduct();
    void storeCDProduct(String name, int price, int tracks);
    void storeBookProduct(String name, int price, int pages);
}
