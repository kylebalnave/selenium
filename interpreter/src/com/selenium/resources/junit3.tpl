package %s;
 
import junit.framework.TestCase;
import static junit.framework.TestCase.fail;
 
public class %s extends TestCase {

    /**
     *  Template Test Method
     */
    public void test%s() {
        try {
            com.selenium.Interpreter interpreter = new com.selenium.Interpreter("%s");
        } catch(com.selenium.exceptions.InterpreterException ex) {
            fail(String.format("%s failed : %s", ex.getMessage()));
        }
    }

}