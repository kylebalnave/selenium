package com.balnave.selenium.steps;

import com.balnave.selenium.testing.PseudoWebDriver;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author kyleb2
 */
public class SetupStepTest {
    
    /**
     * Test of run method, of class SetupStep.
     */
    @Test
    public void testRunExistingDriver() throws InterruptedException {
        System.out.println("testRunExistingDriver");
        WebDriver wd = new HtmlUnitDriver(true);
        SetupStep instance = new SetupStep();
        assertEquals(wd, instance.run(wd));
        if(wd != null) {
            wd.quit();
        }
    }
    
    @Test
    public void testRunCreatingDriver() throws InterruptedException {
        System.out.println("testRunCreatingDriver");
        WebDriver wd = null;
        SetupStep instance = new SetupStep();
        assertTrue(instance.run(wd) instanceof PseudoWebDriver);
    }

    /**
     * Test of toJavaString method, of class SetupStep.
     */
    @Test
    public void testToJavaString() {
        System.out.println("toJavaString");
        SetupStep instance = new SetupStep();
        String result = instance.toJavaString();
        assertTrue(!result.isEmpty());
    }
    
}
