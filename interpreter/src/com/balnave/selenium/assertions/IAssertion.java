package com.balnave.selenium.assertions;

import com.balnave.selenium.steps.IStep;

/**
 * Interface for steps that can be tested
 * @author balnave
 */
public interface IAssertion extends IStep {
    
    public boolean test(Object[] args);
}
