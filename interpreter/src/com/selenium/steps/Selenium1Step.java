/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selenium.steps;

import com.selenium.exceptions.StepException;

/**
 *
 * @author kyleb2
 */
public abstract class Selenium1Step extends Step implements IStep {
    
    protected String name;
    protected String param1;
    protected String param2;

    public Selenium1Step(Object... args) throws StepException {
        super(args);
        if (args.length != 3) {
            throw new StepException(String.format("Selenium1Step expects %s args but received %s", 3, args.length));
        }
        if (!(args[0] instanceof String)) {
            throw new StepException(String.format("Selenium1Step expects args[%s] to be a String but got %s", 0, args[0]));
        } else {
            name = (String) args[0];
        }
        if (!(args[1] instanceof String)) {
            throw new StepException(String.format("Selenium1Step expects args[%s] to be a String but got %s", 1, args[1]));
        } else {
            param1 = (String) args[1];
        }
        if (!(args[2] instanceof String)) {
            throw new StepException(String.format("Selenium1Step expects args[%s] to be a String but got %s", 2, args[2]));
        } else {
            param2 = (String) args[2];
        }
    }
}
