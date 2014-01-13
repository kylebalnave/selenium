package com.selenium.assertions;

import com.selenium.steps.IStep;

/**
 *
 * @author balnave
 */
public abstract class Is implements ITest, IStep {
    
    ITest test;
    
    public Is (ITest test) {
        this.test = test;
    }

    @Override
    public Object run() {
        return test();
    }
    
}
