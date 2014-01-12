/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common.io;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author kyleb2
 */
public class ReaderFactoryTest {
    
    @Test
    public void testGetURLReader() {
        System.out.println("testGetURLReader");
        String fileOrUrl = "http://www.file.com/file/";
        ReaderFactory instance = new ReaderFactory();
        StringReader result = instance.getReader(fileOrUrl);
        assertTrue(result instanceof URLReader);
    }
    
    @Test
    public void testGetFileReader() {
        System.out.println("testGetFileReader");
        String fileOrUrl = "./test/assets/selenium1.html";
        ReaderFactory instance = new ReaderFactory();
        StringReader result = instance.getReader(fileOrUrl);
        assertTrue(result instanceof FileReader);
    }
    
}
