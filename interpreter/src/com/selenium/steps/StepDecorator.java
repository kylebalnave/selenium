package com.selenium.steps;

/**
 * The Abstract Step Decorator
 * @author kyleb2
 */
public abstract class StepDecorator implements IStep {
    
    protected final IStep step;
        
    public StepDecorator(IStep step) {
        this.step = step;
    }
        
}
