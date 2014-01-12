package com.selenium.interpreter.ide;

import com.selenium.exceptions.ParserException;

/**
 * Returns a SeleneseParser
 * @author balnave
 */
public class SeleneseParserFactory {
    
    public ISeleneseParser getParser(String testCasePath) throws ParserException {
        if(testCasePath.matches("^.*\\.(htm|html)$")) {
            return new Selenium1Parser();
        } else if(testCasePath.matches("^.*\\.(json)$")) {
            return new Selenium2Parser();
        } else {
            throw new ParserException(String.format("Cannot create parser for %s.  Each Selenese TestCase should be a HTML or JSON file", testCasePath));
        }
    }
    
}
