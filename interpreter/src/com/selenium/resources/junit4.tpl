package %s;
 
public class %sTest {

    /**
     *  Template Test Method
     */
    @Test
    public void test%s() {
        try {
        new com.selenium.Interpreter("%s");
        } catch(com.selenium.exceptions.InterpreterException ex) {
            fail(String.format("%s failed : %s", ex.getMessage()));
        }
    }

}