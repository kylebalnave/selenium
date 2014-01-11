package com.balnave.selenium.exceptions;

/**
 * A Parser Exception
 * @author balnave
 */
public class InvalidSeleneseException extends Exception {

    public InvalidSeleneseException(String message) {
        super(message);
    }

    public InvalidSeleneseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSeleneseException(Throwable cause) {
        super(cause);
    }
    
}
