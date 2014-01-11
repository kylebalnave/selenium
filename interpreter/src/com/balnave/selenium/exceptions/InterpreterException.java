package com.balnave.selenium.exceptions;

/**
 * A Parser Exception
 * @author balnave
 */
public class InterpreterException extends Exception {

    public InterpreterException(String message) {
        super(message);
    }

    public InterpreterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InterpreterException(Throwable cause) {
        super(cause);
    }
    
}
