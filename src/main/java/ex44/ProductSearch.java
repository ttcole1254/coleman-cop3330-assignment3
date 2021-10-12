package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Coleman
 */

import com.google.gson.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

record Products(String name, double price, int quantity) {
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}

public class ProductSearch {
    public static Scanner in = new Scanner(System.in);
    public static String filePath = System.getProperty("user.dir");
    public static void main(String[] args) {
        String inputPath = filePath + "/exercise44_input.json";
        String output;
        List<Products> products = getProducts(inputPath);
        output = searchForProduct(products);
        System.out.println(output);
    }
    public static List<Products> getProducts(String inputPath) {
        File input = new File(inputPath);
        List<Products> products = null;
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray jsonArrayProducts = fileObject.get("products").getAsJsonArray();
            products = new ArrayList<>();
            for (JsonElement productJson : jsonArrayProducts) {
                JsonObject productJsonObject = productJson.getAsJsonObject();
                String name = productJsonObject.get("name").getAsString();
                double price = productJsonObject.get("price").getAsDouble();
                int quantity = productJsonObject.get("quantity").getAsInt();

                Products product = new Products(name, price, quantity);
                products.add(product);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
    public static String searchForProduct(List<Products> products) {
        String search;
        String foundName;
        double foundPrice;
        int foundQuantity;
        String output = null;
        do {
            System.out.println("What is the product name? ");
            search = in.nextLine().toLowerCase();
            Products foundProduct = search(products, search);
            foundName = foundProduct.getName();
            foundPrice = foundProduct.getPrice();
            foundQuantity = foundProduct.getQuantity();
            if(foundName == null) {
                System.out.println("Sorry, that product was not found in our inventory.");
            }
            else {
                DecimalFormat df = new DecimalFormat("0.00");
                output = String.format("Name: %s\nPrice: $%s\nQuantity: %d", foundName, df.format(foundPrice), foundQuantity);
            }
        } while (foundName == null);
        return output;
    }

    public static Products search(List<Products> products, String search) {
        if (products != null) {
            for (Products p : products) {
                if (p.getName() != null && p.getName().toLowerCase().contains(search)) {
                    return p;
                }
                assert p.getName() != null;
            }
        }
        return new Products(null, 0, 0);
    }
}