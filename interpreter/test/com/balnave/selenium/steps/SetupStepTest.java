/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balnave.selenium.steps;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author kyleb2
 */
public class SetupStepTest {
    
    /**
     * Test of run method, of class SetupStep.
     */
    @Test
    public void testRun() throws InterruptedException {
        System.out.println("run");
        WebDriver wd = null;
        SetupStep instance = new SetupStep();
        wd = instance.run(wd);
        assertTrue(String.format("Expecting a WebDriver but got %s", wd), wd != null);
        Thread.sleep(2000);
        if(wd != null) {
            wd.quit();
        }
    }

    /**
     * Test of toJavaString method, of class SetupStep.
     */
    @Test
    public void testToJavaString() {
        System.out.println("toJavaString");
        SetupStep instance = new SetupStep();
        String result = instance.toJavaString();
        System.out.println(result);
        assertTrue(!result.isEmpty());
    }
    
}
