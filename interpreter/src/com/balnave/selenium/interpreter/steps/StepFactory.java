/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balnave.selenium.interpreter.steps;

/**
 *
 * @author kyleb2
 */
public class StepFactory {
    
    public IStep buildStep(String[] args) {
        return buildStep(args[0], args[1], args[2]);
    }
    
    public IStep buildStep(String stepName, String param1, String param2) {
        return null;
    }
    
}
