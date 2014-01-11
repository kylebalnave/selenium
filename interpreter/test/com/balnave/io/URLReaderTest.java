/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balnave.io;

import com.balnave.selenium.testing.TestServer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author kyleb2
 */
public class URLReaderTest {
    

    @Test
    public void testLoadValidUrl() throws Exception {
        System.out.println("testLoadValidUrl");
        TestServer.start("Hello World!");
        URLReader instance = new URLReader("http://127.0.0.1:7777/");
        String content = instance.load();
        assertTrue(content.contains("Hello World!"));
        TestServer.stop();
    }
    
    @Test
    public void testLoadInValidUrl() {
        System.out.println("testLoadInValidUrl");
        URLReader instance = new URLReader("http://127.0.0.1:7778/");
        String content = instance.load();
        assertEquals(content, "");
    }
    
}