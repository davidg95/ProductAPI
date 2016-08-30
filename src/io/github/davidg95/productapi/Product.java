/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.productapi;

import java.io.Serializable;

/**
 * Class of type product which can be extended.
 *
 * @author David
 */
public class Product implements Serializable {

    private String name;
    private String make;
    private String description;
    private double price;
    private int stock;
    private String comments;
    private String code;

    /**
     * Blank constructor.
     */
    public Product() {

    }

    /**
     * Constructor which takes in name, price, code and stock level.
     *
     * @param name the name of the product.
     * @param make the make of the product.
     * @param code the product code as a String.
     * @param price the price of the product.
     * @param stock the stock level of the product.
     */
    public Product(String name, String make, String code, double price, int stock) {
        this.name = name;
        this.make = make;
        this.price = price;
        this.stock = stock;
        this.code = code;
    }
    
    /**
     * Constructor which takes in name, price and stock level.
     *
     * @param name the name of the product.
     * @param make the make of the product.
     * @param price the price of the product.
     * @param stock the stock level of the product.
     */
    public Product(String name, String make, double price, int stock) {
        this.name = name;
        this.make = make;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Constructor which takes in a name, description, price and stock level.
     *
     * @param name the name of the product.
     * @param make the make of the product.
     * @param code the product code as a String.
     * @param description a description for the product.
     * @param price the price of the product.
     * @param stock the stock level of the product.
     */
    public Product(String name, String make, String code, String description, double price, int stock) {
        this(name, make, code, price, stock);
        this.description = description;
        this.comments = "No Comments";
    }

    /**
     * Constructor which takes in a name, description, price, stock level and
     * comments.
     *
     * @param name the name of the product.
     * @param make the make of the product.
     * @param code the product code as a String.
     * @param description a description for the product.
     * @param price the price of the product.
     * @param stock the stock level of the product.
     * @param comments any comments about the product.
     */
    public Product(String name, String make, String code, String description, double price, int stock, String comments) {
        this(name, make, code, description, price, stock);
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String productCode) {
        this.code = productCode;
    }

    /**
     * Method to generate a product code by taking the first 3 letter from the
     * name and then adding 3 random numbers.
     */
    public void generateProductCode() {
        code = name.substring(0, 3) + (int) (Math.random() * 10) + (int) (Math.random() * 10) + (int) (Math.random() * 10);
    }

    /**
     * Method to purchase a product by reducing its stock level by 1.
     *
     * @throws OutOfStockException if the product is out of stock.
     */
    public void purchase() throws OutOfStockException {
        if (this.stock > 0) {
            this.stock--;
        } else {
            throw new OutOfStockException(this.code + " is out of stock");
        }
    }

    /**
     * Method to increase the stock level by a given amount.
     *
     * @param s the amount to increase the stock level by.
     */
    public void increaseStock(int s) {
        this.stock += s;
    }

    /**
     * Method to compare two products by the product code.
     *
     * @param p the product to compare.
     * @return true if they are equal.
     */
    public boolean equals(Product p) {
        return this.code.equals(p.getCode());
    }

    /**
     * Method to format output for saving to a notepad file.
     *
     * @return returns a String formatted for output to a notepad file.
     */
    public String toCSV() {
        return this.name + "," + this.code + "," + this.description + "," + this.stock + "," + this.price;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nProduct Code: " + this.code + "\nDescription: " + this.description + "\nPrice: £" + this.price + "\nStock: " + this.stock + "\nComments: " + this.comments;
    }
}
