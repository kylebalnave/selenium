package com.balnave.selenium.interpreter.assertions;

import com.balnave.selenium.interpreter.steps.IStep;

/**
 * Interface for steps that can be tested
 * @author balnave
 */
public interface IAssertion extends IStep {
    
    public boolean test(Object[] args);
}
