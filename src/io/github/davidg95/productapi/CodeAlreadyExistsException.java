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

    public CodeAlreadyExistsException(String message) {
        super(message);
    }
}
