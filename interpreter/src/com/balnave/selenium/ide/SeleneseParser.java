package com.balnave.selenium.ide;

import com.balnave.selenium.steps.Step;
import java.util.List;

/**
 * Interface for all saved Selenium files
 * @author balnave
 */
public interface SeleneseParser {
    
    public List<Step> parse(String content);
    
}
