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

    public OutOfStockException(String message) {
        super(message);
    }
}
