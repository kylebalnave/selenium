package com.balnave.selenium;

import com.balnave.io.ReaderFactory;
import com.balnave.io.StringReader;
import com.balnave.selenium.drivers.DriverFactory;
import com.balnave.selenium.exceptions.InterpreterException;
import com.balnave.selenium.exceptions.InvalidSeleneseException;
import com.balnave.selenium.exceptions.ParserException;
import com.balnave.selenium.interpreter.ide.ISeleneseParser;
import com.balnave.selenium.interpreter.ide.SeleneseParserFactory;
import com.balnave.selenium.steps.IStep;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Reads a Selenese TestCase from SeleniumIDE or SeleniumBuilder and executes.
 * @author balnave
 */
public class Interpreter {
    
    private static final Logger LOG = Logger.getLogger(Interpreter.class.getName());
    
     /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        System.out.println("Usage: [--driver.type=<drivername] [--driver.hub=<drivername] [--junit.outj=<drivername] <script path>...");
        System.out.println(args.length);
        //@TODO validate the args
        for (String s : args) {
            System.out.println(s);
        }
    }

    public Interpreter(String testCasePathOrUrl) throws InterpreterException {
        ReaderFactory readerFactory = new ReaderFactory();
        StringReader reader = readerFactory.getReader(testCasePathOrUrl);
        String readerResponseSource = reader.load();
        if(!reader.isReady()) {
            throw new InterpreterException(String.format("Error loading Selenese file %s : %s", testCasePathOrUrl, reader.getErrorMsg()));
        }
        SeleneseParserFactory parserFactory = new SeleneseParserFactory();
        ISeleneseParser parser;
        try {
            parser = parserFactory.getParser(testCasePathOrUrl);
        } catch (ParserException ex) {
            throw new InterpreterException(String.format("File Parsing Error"), ex);
        }
        List<IStep> steps;
        try {
            steps = parser.parse(readerResponseSource);
        } catch (InvalidSeleneseException ex) {
            throw new InterpreterException(String.format("Step Creation Error"), ex);
        } catch (ParserException ex) {
            throw new InterpreterException(String.format("Step Parsing Error"), ex);
        }
        //
        // get the correct WebDriver
        DriverFactory driverFactory = new DriverFactory();
        String driverType = "firefox";
        WebDriver driver;
        try {
            driver = driverFactory.getDriver(driverType);
        } catch (MalformedURLException ex) {
            throw new InterpreterException(String.format("WebDriver Creation Error"), ex);
        }
        WebDriverExecutor executor = new WebDriverExecutor(driver, steps);
    }
    
    
    
}
