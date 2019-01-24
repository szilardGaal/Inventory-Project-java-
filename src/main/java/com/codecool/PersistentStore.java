package com.codecool;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PersistentStore extends Store {

    private final File xmlFile = new File("src/main/java/data/products.xml");
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
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Products");
            doc.appendChild(rootElement);

            Element productTag = doc.createElement("Product");
            rootElement.appendChild(productTag);

            productTag.setAttribute("name", product.getName());
            productTag.setAttribute("price", Integer.toString(product.getPrice()));
            productTag.setAttribute("size", Integer.toString(product.getSize()));
            productTag.setAttribute("type", product.toString());

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    @Override
    public List<Product> loadProducts() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Product");

            for (int i=0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == nNode.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    allProducts.add(createProduct(eElement.getAttribute("type"),
                        eElement.getAttribute("name"),
                        Integer.parseInt(eElement.getAttribute("price")),
                        Integer.parseInt(eElement.getAttribute("size"))));
                }
            }

            return allProducts;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
