/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.productapi;

import java.util.ArrayList;

/**
 * ProductList class which extends the ArrayList class. Stores a list of
 * products.
 *
 * @author David
 */
public class ProductList extends ArrayList<Product> {

    /**
     * Blank constructor.
     */
    public ProductList() {
        super();
    }

    public void addProduct(Product p) throws CodeAlreadyExistsException {
        for (Product product : this) {
            if (product.getCode().equals(p.getCode())) {
                throw new CodeAlreadyExistsException(p.getCode());
            }
        }
        p.generateProductCode();
        this.add(p);
        System.out.println(p);
    }

    /**
     * Method to purchase a product by its product code.
     *
     * @param code the code to purchase.
     * @throws OutOfStockException if the product is out of stock.
     * @throws ProductNotFoundException if the product code was not found.
     */
    public void purchase(String code) throws OutOfStockException, ProductNotFoundException {
        for (Product p : this) {
            if (p.getCode().equals(code)) {
                p.purchase();
                return;
            }
        }
        throw new ProductNotFoundException(code + " not found");
    }

    /**
     * Method to purchase a product by its position in the list.
     *
     * @param i the position.
     * @throws OutOfStockException if the product is out of stock.
     * @throws ProductNotFoundException if no product was found at that
     * position.
     */
    public void purchase(int i) throws OutOfStockException, ProductNotFoundException {
        if (i < super.size()) {
            super.get(i).purchase();
            return;
        }
        throw new ProductNotFoundException("No product found");
    }

    /**
     * Method to increase the stock level of a product by its product code.
     *
     * @param code the product code in increase.
     * @param stock the amount of stock to add.
     * @throws ProductNotFoundException if the product code was not found.
     */
    public void increaseStock(String code, int stock) throws ProductNotFoundException {
        for (Product p : this) {
            if (p.getCode().equals(code)) {
                p.increaseStock(stock);
                return;
            }
        }
        throw new ProductNotFoundException(code + " not found");
    }

    /**
     * Method to remove a product by its product code.
     *
     * @param code the product code of the product to remove.
     * @throws ProductNotFoundException if the product code was not found.
     */
    public void remove(String code) throws ProductNotFoundException {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getCode().equals(code)) {
                super.remove(i);
                return;
            }
        }
        throw new ProductNotFoundException(code + " not found");
    }

    /**
     * Method to update a product.
     *
     * @param p the product object with the new product details.
     * @throws ProductNotFoundException if the product could not be found.
     */
    public void updateProduct(Product p) throws ProductNotFoundException {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(p)) {
                this.set(i, p);
                return;
            }
        }
        throw new ProductNotFoundException(p.getCode() + " not found");
    }

    /**
     * Method to get the stock level of a Product by its product code.
     *
     * @param code the code to search for.
     * @return integer value representing the stock level.
     * @throws ProductNotFoundException if the product code was not found.
     */
    public int getStock(String code) throws ProductNotFoundException {
        for (Product p : this) {
            if (p.getCode().equals(code)) {
                return p.getStock();
            }
        }
        throw new ProductNotFoundException(code);
    }

    /**
     * Method to get a product by the product code.
     *
     * @param code the code to search for.
     * @return a Product object.
     * @throws ProductNotFoundException if the product code was not found.
     */
    public Product getProduct(String code) throws ProductNotFoundException {
        for (Product p : this) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        throw new ProductNotFoundException(code + " not found");
    }
}
