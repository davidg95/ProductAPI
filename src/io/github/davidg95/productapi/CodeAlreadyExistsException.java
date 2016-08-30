/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.productapi;

/**
 * CodeAlreadyExistsException which can be thrown if a code already exists.
 *
 * @author David
 */
public class CodeAlreadyExistsException extends Exception {

    private final String code;

    public CodeAlreadyExistsException(String code) {
        super();
        this.code = code;
    }

    @Override
    public String getMessage() {
        return code + " already exists";
    }

    @Override
    public String toString() {
        return "Exception: " + code + " already exists";
    }
}