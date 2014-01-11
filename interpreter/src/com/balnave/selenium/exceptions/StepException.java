package com.balnave.selenium.exceptions;

/**
 * A Parser Exception
 * @author balnave
 */
public class StepException extends Exception {

    public StepException(String message) {
        super(message);
    }

    public StepException(String message, Throwable cause) {
        super(message, cause);
    }

    public StepException(Throwable cause) {
        super(cause);
    }
    
}
