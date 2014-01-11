/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balnave.selenium.interpreter.ide;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author kyleb2
 */
public class SeleneseParserFactoryTest {
    
    @Test
    public void testGetSelenium1Parser() {
        System.out.println("testGetSelenium1Parser");
        SeleneseParserFactory instance = new SeleneseParserFactory();
        ISeleneseParser parser = instance.getParser("./test/assets/selenium1.html");
        assertTrue(parser instanceof Selenium1Parser);
    }
    
    @Test
    public void testGetSelenium2Parser() {
        System.out.println("testGetSelenium2Parser");
        SeleneseParserFactory instance = new SeleneseParserFactory();
        ISeleneseParser parser = instance.getParser("./test/assets/selenium2.json");
        assertTrue(parser instanceof Selenium2Parser);
    }
    
}
