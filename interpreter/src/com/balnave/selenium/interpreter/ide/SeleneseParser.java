package com.balnave.selenium.interpreter.ide;

import com.balnave.selenium.interpreter.steps.Step;
import java.util.List;

/**
 * Interface for all saved Selenium files
 * @author balnave
 */
public interface SeleneseParser {
    
    public List<Step> parse(String content);
    
}
