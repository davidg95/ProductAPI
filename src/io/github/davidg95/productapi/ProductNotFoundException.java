/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.productapi;

/**
 * ProductNotFoundException which can be thrown if a product was not found.
 *
 * @author David
 */
public class ProductNotFoundException extends Exception {

    private final String code;

    public ProductNotFoundException(String code) {
        super();
        this.code = code;
    }

    @Override
    public String getMessage() {
        return code + " not found";
    }

    @Override
    public String toString() {
        return "Exception: " + code + " not found";
    }
}
