/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balnave.selenium.steps;

import com.balnave.selenium.steps.IStep;

/**
 *
 * @author kyleb2
 */
public class StepFactory {
    
    public IStep buildStep(String[] args) {
        String stepName = args[0];
        if(stepName.equals("open")) {
            return new OpenStep(args);
        }
        return null;
    }
    
    public IStep buildStep(String stepName, String param1, String param2) {
        String[] args = new String[3];
        args[0] = stepName;
        args[1] = param1;
        args[2] = param2;
        return buildStep(args);
    }
    
}
