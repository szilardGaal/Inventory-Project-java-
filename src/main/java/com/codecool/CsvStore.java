package com.codecool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvStore extends Store {

    private final File csvFile = new File("src/main/java/data/products.csv");
    private List<Product> allProducts = new ArrayList<>();

    @Override
    public void storeProduct(Product product) {
        if (product instanceof CDProduct) {
            storeCDProduct(product.getName(), product.getPrice(), product.getSize());
        }

        if (product instanceof BookProduct) {
            storeBookProduct(product.getName(), product.getPrice(), product.getSize());
        }
    }

    @Override
    public void saveToXml(Product product) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true));
            String stringToWrite = product.getName() + "," + product.getPrice() + "," + product.getSize();
            if (product instanceof BookProduct) {
                stringToWrite += ",book\n";
            }
            if (product instanceof CDProduct) {
                stringToWrite += ",cd\n";
            }
            writer.write(stringToWrite);
            writer.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    @Override
    public List<Product> loadProducts() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String[] data;
            while (reader.ready()) {
                data = reader.readLine().split(",");
                if (data[3].equals("book")) {
                    allProducts.add(new BookProduct(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                }
                if (data[3].equals("cd")) {
                    allProducts.add(new CDProduct(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                }
            }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException ie) {
                ie.printStackTrace();
        }
        return null;

    }
}
