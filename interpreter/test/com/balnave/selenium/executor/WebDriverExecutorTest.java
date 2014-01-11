/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balnave.selenium.executor;

import com.balnave.selenium.WebDriverExecutor;
import com.balnave.selenium.assertions.UrlEqualsAssertion;
import com.balnave.selenium.steps.IStep;
import com.balnave.selenium.steps.OpenStep;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author balnave
 */
public class WebDriverExecutorTest {
    
    @Test
    public void testSetup() {
        System.out.println("setup");
        WebDriver wd = new HtmlUnitDriver(true);
        List<IStep> steps = new ArrayList<IStep>();
        steps.add(new OpenStep("", "http://www.google.co.uk/"));
        steps.add(new OpenStep("", "http://www.google.co.uk/pears"));
        steps.add(new UrlEqualsAssertion("http://www.google.co.uk/pears"));
        WebDriverExecutor executor = new WebDriverExecutor(wd, steps);
    }
    
}
