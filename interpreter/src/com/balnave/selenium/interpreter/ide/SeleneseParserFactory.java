package com.balnave.selenium.interpreter.ide;

/**
 * Decides which type of SlenesePaerser to use
 * @author balnave
 */
public class SeleneseParserFactory {
    
    public ISeleneseParser getParser(String testCase) {
        if(testCase.matches("^.*\\.(htm|html|xml)$")) {
            return new Selenium1Parser();
        } else if(testCase.matches("^.*\\.(json)$")) {
            return new Selenium2Parser();
        } 
        return null;
    }
    
}
