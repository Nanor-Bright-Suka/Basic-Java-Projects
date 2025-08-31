package com.myapi.handler;


import com.google.gson.JsonObject;
import com.myapi.db.BookRepository;
import com.myapi.model.Books;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;


import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import com.google.gson.Gson;


public class BooksHandler implements HttpHandler {
    private final BookRepository repo = new BookRepository();
    private final Gson gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestBody = new String(exchange.getRequestBody().readAllBytes());

        if ("GET".equals(exchange.getRequestMethod())) {
            try {
                List<Books> books = repo.getAllBooks();
                String json = gson.toJson(books);

                exchange.getResponseHeaders().add("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, json.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(json.getBytes());
                }

            } catch (SQLException e) {
                e.printStackTrace(); // log stack trace
                String error = "Database error: " + e.getMessage();
                exchange.sendResponseHeaders(500, error.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(error.getBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
                String error = "Unexpected error: " + e.getMessage();
                exchange.sendResponseHeaders(500, error.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(error.getBytes());
                }
            }

        } else if ("POST".equals(exchange.getRequestMethod())) {
            try {
                // Read request body
                Books newBook = gson.fromJson(requestBody, Books.class);

                // Insert book into database
                repo.insertBook(newBook);

                String response = "Book added successfully";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }

            } catch (SQLException e) {
                e.printStackTrace(); // log stack trace
                String error = "Database error: " + e.getMessage();
                exchange.sendResponseHeaders(500, error.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(error.getBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
                String error = "Unexpected error: " + e.getMessage();
                exchange.sendResponseHeaders(500, error.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(error.getBytes());
                }
            }
        } else if ("PATCH".equals(exchange.getRequestMethod())) {

            try {
                // Read request body
                Books newBook = gson.fromJson(requestBody, Books.class);

                // Insert book into database
                repo.updateBook(newBook);

                String response = "Book updated successfully";
                exchange.sendResponseHeaders(201, response.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }

            } catch (SQLException e) {
                e.printStackTrace(); // log stack trace
                String error = "Database error: " + e.getMessage();
                exchange.sendResponseHeaders(500, error.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(error.getBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
                String error = "Unexpected error: " + e.getMessage();
                exchange.sendResponseHeaders(500, error.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(error.getBytes());
                }
            }
        }else if("DELETE".equals(exchange.getRequestMethod())){
            try {

                JsonObject json = gson.fromJson(requestBody, JsonObject.class);
                String title = json.get("title").getAsString();
                repo.deleteBook(title);


                String response = "Book deleted successfully";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }

            } catch (SQLException e) {
                e.printStackTrace(); // log stack trace
                String error = "Database error: " + e.getMessage();
                exchange.sendResponseHeaders(500, error.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(error.getBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
                String error = "Unexpected error: " + e.getMessage();
                exchange.sendResponseHeaders(500, error.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(error.getBytes());
                }
            }

        }else{
            String response = "Method Not Allowed";
            exchange.sendResponseHeaders(405, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}


