package com.selenium.assertions;

import com.selenium.steps.IStep;

/**
 *
 * @author balnave
 */
public abstract class Is implements IVerify, IStep {
    
    IVerify test;
    
    public Is (IVerify test) {
        this.test = test;
    }

    @Override
    public Object run() {
        return test();
    }
    
}
