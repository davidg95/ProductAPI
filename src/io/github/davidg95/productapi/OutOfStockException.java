/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.productapi;

/**
 * OutOfStockException which can be thrown if a product is out of stock.
 *
 * @author David
 */
public class OutOfStockException extends Exception {

    private final String code;

    public OutOfStockException(String code) { 
        super();
        this.code = code;
    }

    @Override
    public String getMessage() {
        return code + " is out of stock";
    }

    @Override
    public String toString() {
        return "Exception: " + code + " is out of stock";
    }
}