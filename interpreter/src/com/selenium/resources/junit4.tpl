package %s;

import static junit.framework.TestCase.fail;
import org.junit.Test;
 
public class %s {

    /**
     *  Template Test Method
     */
    @Test
    public void test%s() {
        try {
            com.selenium.Interpreter interpreter = new com.selenium.Interpreter("%s");
        } catch(com.selenium.exceptions.InterpreterException ex) {
            fail(String.format("%s failed : %s", ex.getMessage()));
        }
    }

}