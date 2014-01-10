/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balnave.selenium.interpreter.ide;

import com.balnave.selenium.steps.IStep;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kyleb2
 */
public class Selenium2ParserTest {
    
    public Selenium2ParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, of class Selenium2Parser.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        String content = "";
        Selenium2Parser instance = new Selenium2Parser();
        List<IStep> expResult = null;
        List<IStep> result = instance.parse(content);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
