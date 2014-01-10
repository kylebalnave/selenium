package com.balnave.selenium.interpreter.assertions;

import com.balnave.selenium.interpreter.steps.Step;

/**
 * The simplest assertion type
 * @author kyleb2
 */
public abstract class Assertion extends Step implements IAssertion {

    public Assertion(Object[] args) {
        super(args);
    }

    @Override
    public boolean test(Object[] args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
