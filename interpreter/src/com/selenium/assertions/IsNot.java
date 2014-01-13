package com.selenium.assertions;

import com.selenium.steps.IStep;

/**
 *
 * @author balnave
 */
public abstract class IsNot extends Is implements ITest, IStep {
    
    public IsNot (ITest test) {
        super(test);
    }

    @Override
    public Object run() {
        return !(super.run().equals(true));
    }
    
}
