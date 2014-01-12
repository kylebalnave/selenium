package %s;
 
import junit.framework.TestCase;
 
public class %sTest extends TestCase {

    /**
     *  Template Test Method
     */
    public void test%s() {
        try {
        new com.selenium.Interpreter("%s");
        } catch(com.selenium.exceptions.InterpreterException ex) {
            fail(String.format("%s failed : %s", ex.getMessage()));
        }
    }

}