package com.selenium.testing;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * TestServer to fake responses
 * @author balnave
 */
public class TestServer {

    public static HttpServer server;
    
    public static void start() throws Exception {
        start("", 404, 7777);
    }
    
    public static void start(String testContent) throws Exception {
        start(testContent, 200, 7777);
    }
    
    public static void start(String testContent, int testStatusCode) throws Exception {
        start(testContent, testStatusCode, 7777);
    }

    public static void start(String testContent, int testStatusCode, int port) throws Exception {
        if (server == null) {
            server = HttpServer.create(new InetSocketAddress("127.0.0.1", port), 0);
            server.createContext("/", new MyHandler(testContent, testStatusCode));
            server.setExecutor(null);
            server.start();
        }
    }

    public static void stop() {
        if (server != null) {
            server.stop(1);
            server = null;
        }
    }

    static class MyHandler implements HttpHandler {
        
        private final String testContent;
        private final int testStatusCode;

        public MyHandler(String testContent, int testStatusCode) {
            this.testContent = testContent;
            this.testStatusCode = testStatusCode;
        }

        public MyHandler() {
            testStatusCode = 404;
            testContent="";
        }
        
        

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = testContent;
            byte[] bytes = response.getBytes();
            exchange.sendResponseHeaders(testStatusCode, bytes.length);
            exchange.getResponseBody().write(bytes);
            exchange.close();
        }

    }
}
