package com.myapi;


import com.myapi.handler.BooksHandler;
import com.myapi.handler.RouteHealth;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;


public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", new RouteHealth());
        server.createContext("/getbooks", new BooksHandler());
        server.createContext("/create-book", new BooksHandler());
        server.createContext("/update-book", new BooksHandler());
        server.createContext("/delete-book", new BooksHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on http://localhost:8080");
    }


}
