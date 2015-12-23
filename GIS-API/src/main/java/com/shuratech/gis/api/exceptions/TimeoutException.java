/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shuratech.gis.api.exceptions;

/**
 *
 * @author abbas
 */
public class TimeoutException extends RuntimeException {

    /**
     * Creates a new instance of <code>TimeoutException</code> without detail
     * message.
     */
    public TimeoutException() {
    }

    /**
     * Constructs an instance of <code>TimeoutException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public TimeoutException(String msg) {
        super(msg);
    }
}
