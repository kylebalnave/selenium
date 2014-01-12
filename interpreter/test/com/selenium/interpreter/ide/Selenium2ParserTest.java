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
public class Selenium2ParserTest {

    protected String validContent = "{\n"
            + "  \"seleniumVersion\": \"2\",\n"
            + "  \"formatVersion\": 1,\n"
            + "  \"steps\": [\n"
            + "    {\n"
            + "      \"type\": \"get\",\n"
            + "      \"url\": \"http://www.sebuilder.com/\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"type\": \"clickElement\",\n"
            + "      \"locator\": {\n"
            + "        \"type\": \"link text\",\n"
            + "        \"value\": \"Apache 2 License\"\n"
            + "      }\n"
            + "    },\n"
            + "    {\n"
            + "      \"type\": \"verifyTextPresent\",\n"
            + "      \"negated\": true,\n"
            + "      \"text\": \"Closed Source Software\"\n"
            + "    }\n"
            + "  ]\n"
            + "}";

    /**
     * Test of parse method, of class Selenium1Parser.
     * @throws com.selenium.exceptions.InvalidSeleneseException
     * @throws com.selenium.exceptions.ParserException
     */
    @Test
    public void testParseValidFile() throws InvalidSeleneseException, ParserException {
        System.out.println("testParseValidFile");
        Selenium2Parser instance = new Selenium2Parser();
        List<IStep> result = instance.parse(validContent);
        assertTrue(result.size() > 0);
    }

    @Test
    public void testParseInValidFile() throws InvalidSeleneseException, ParserException {
        System.out.println("testParseInValidFile");
        Selenium2Parser instance = new Selenium2Parser();
        List<IStep> result = instance.parse("");
        assertTrue(result.isEmpty());
    }

}
