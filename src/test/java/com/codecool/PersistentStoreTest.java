package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersistentStoreTest extends PersistentStore {

    File testFile;
    CDProduct cd;
    BookProduct book;
    List<Product> allProduct;

    @BeforeEach
    void setUp() {
        cd = new CDProduct("disc", 300, 10);
        book = new BookProduct("La Book", 500, 200);
    }

    @Test
    void saveToXml() {
        saveToXml(cd);

    }

    @Test
    void loadProductsTest() {
        allProduct = loadProducts();
        assertEquals("disc",allProduct.get(0).getName());
    }
}
