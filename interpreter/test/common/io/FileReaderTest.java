/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author kyleb2
 */
public class FileReaderTest {

    @Test
    public void testLoad() {
        System.out.println("testLoad");
        FileReader instance = new FileReader("./test/assets/selenium1.html");
        String content = instance.load();
        assertTrue(content.contains("<html"));
    }
    
    @Test
    public void testLoadFailure() {
        System.out.println("testLoadFailure");
        FileReader instance = new FileReader("./test/assets/selenium1.html.doesntexist");
        String content = instance.load();
        assertEquals(content, "");
    }
    
}
