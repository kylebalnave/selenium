/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selenium.interpreter.ide;

import com.selenium.exceptions.InvalidSeleneseException;
import com.selenium.exceptions.ParserException;
import com.selenium.steps.IStep;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author kyleb2
 */
public class Selenium1ParserTest {

    protected String validContent = "<table cellpadding=\"1\" cellspacing=\"1\" border=\"1\">\n"
            + "            <thead>\n"
            + "                <tr><td rowspan=\"1\" colspan=\"3\">testCase</td></tr>\n"
            + "            </thead><tbody>\n"
            + "                <tr>\n"
            + "                    <td>open</td>\n"
            + "                    <td>/?gws_rd=cr&amp;ei=nwaFUoKnCaKV0AW8m4D4DQ</td>\n"
            + "                    <td></td>\n"
            + "                </tr>\n"
            + "                <tr>\n"
            + "                    <td>type</td>\n"
            + "                    <td>id=gbqfq</td>\n"
            + "                    <td>hello</td>\n"
            + "                </tr>\n"
            + "                <tr>\n"
            + "                    <td>type</td>\n"
            + "                    <td>id=gbqfq</td>\n"
            + "                    <td>hello world</td>\n"
            + "                </tr>\n"
            + "                <tr>\n"
            + "                    <td>click</td>\n"
            + "                    <td>id=gbqfb</td>\n"
            + "                    <td></td>\n"
            + "                </tr>\n"
            + "                <tr>\n"
            + "                    <td>clickAndWait</td>\n"
            + "                    <td>link=Hello world program - Wikipedia, the free encyclopedia</td>\n"
            + "                    <td></td>\n"
            + "                </tr>\n"
            + "                <tr>\n"
            + "                    <td>click</td>\n"
            + "                    <td>css=li.toclevel-1.tocsection-4 &gt; a &gt; span.toctext</td>\n"
            + "                    <td></td>\n"
            + "                </tr>\n"
            + "\n"
            + "            </tbody></table>";

    /**
     * Test of parse method, of class Selenium1Parser.
     * @throws com.selenium.exceptions.InvalidSeleneseException
     * @throws com.selenium.exceptions.ParserException
     */
    @Test
    public void testParseValidFile() throws InvalidSeleneseException, ParserException {
        System.out.println("testParseValidFile");
        Selenium1Parser instance = new Selenium1Parser();
        List<IStep> result = instance.parse(validContent);
        assertTrue(result.size() > 0);
    }
    
    @Test
    public void testParseInValidFile() throws InvalidSeleneseException, ParserException {
        System.out.println("testParseInValidFile");
        Selenium1Parser instance = new Selenium1Parser();
        List<IStep> result = instance.parse("");
        assertTrue(result.isEmpty());
    }

}
