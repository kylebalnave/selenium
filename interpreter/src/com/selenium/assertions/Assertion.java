package com.selenium.assertions;

import com.selenium.steps.Step;

/**
 * The Abstract Class
 * @author kyleb2
 */
public abstract class Assertion extends Step {
    
    Object valueToAssert;

    public Assertion(Object valueToAssert) {
        this.valueToAssert = valueToAssert;
    }
    
}
