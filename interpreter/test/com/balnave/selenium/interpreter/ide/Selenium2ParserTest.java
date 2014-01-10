/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balnave.selenium.interpreter.ide;

import com.balnave.selenium.steps.IStep;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

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
     */
    @Test
    public void testParseValidFile() {
        System.out.println("testParseValidFile");
        Selenium2Parser instance = new Selenium2Parser();
        List<IStep> result = instance.parse(validContent);
        assertTrue(result.size() > 0);
    }

    @Test
    public void testParseInValidFile() {
        System.out.println("testParseInValidFile");
        Selenium2Parser instance = new Selenium2Parser();
        List<IStep> result = instance.parse("");
        assertTrue(result.isEmpty());
    }

}
