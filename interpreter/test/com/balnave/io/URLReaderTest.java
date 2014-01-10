/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.balnave.io;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kyleb2
 */
public class URLReaderTest {
    
    
    public URLReaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        SimpleServer.start();
    }
    
    @After
    public void tearDown() {
        SimpleServer.stop();
    }

    @Test
    public void testLoadValidUrl() {
        System.out.println("testLoadValidUrl");
        URLReader instance = new URLReader("http://127.0.0.1:7777/");
        String content = instance.load();
        assertTrue(content.contains("Hello World!"));
    }
    
    @Test
    public void testLoadInValidUrl() {
        System.out.println("testLoadInValidUrl");
        URLReader instance = new URLReader("http://127.0.0.1:7778/");
        String content = instance.load();
        assertEquals(content, "");
    }
    
}

class SimpleServer {

    public static HttpServer server;

    public static void start() throws Exception {
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 7777), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public static void stop() {
        server.stop(1);
        server = null;
    }

    static class MyHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello World!";
            byte[] bytes = response.getBytes();
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, bytes.length);
            exchange.getResponseBody().write(bytes);
            exchange.close();
        }

    }
}
