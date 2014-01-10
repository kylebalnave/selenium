package com.balnave.selenium.interpreter.ide;

import com.balnave.selenium.interpreter.ide.ISeleneseParser;
import com.balnave.selenium.interpreter.steps.IStep;
import java.util.List;

/**
 * Selenium 1 (aka Selenium IDE) HTML parser
 * @author balnave
 */
public class Selenium1Parser implements ISeleneseParser {

    @Override
    public List<IStep> parse(String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
