package com.selenium.steps;

/**
 * The simplest Step
 * @author kyleb2
 */
public abstract class Step implements IStep {
    
    protected Object[] args;
    
    public Step(Object... args) {
        this.args = args;
    }
 
    /**
     * Gets an argument value with a default fallback
     * @param index
     * @param defaultObject
     * @return 
     */
    protected Object getArg(int index, Object defaultObject) {
        return args.length - 1 >= index ? args[index] : defaultObject;
    } 
    /**
     * Gets an argument value with NO default fallback
     * @param index
     * @return 
     */
    protected Object getArg(int index) {
        return getArg(index, null);
    } 
        
}
