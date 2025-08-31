package com.myapi.db;

import com.myapi.model.Books;

import java.sql.*;
import java.util.*;


public class BookRepository {

    public List<Books> getAllBooks() throws SQLException {
        List<Books> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                books.add(new Books(
                        rs.getString("title"),
                        rs.getDouble("price"),
                        rs.getString("author")));

            }

        } catch (SQLException e) {
            // Don't swallow the exception — throw it upwards
            throw new SQLException("Error fetching books from database", e);
        }

        return books;
    }

    public void insertBook(Books book) throws SQLException {
        String sql = "INSERT INTO books (title, price, author) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setDouble(2, book.getPrice());
            stmt.setString(3, book.getAuthor());
            stmt.executeUpdate();
            System.out.println("Book inserted successfully");
        } catch (SQLException e) {
            throw new SQLException("Error inserting book into database", e);
        }
    }



    public void updateBook(Books book) throws SQLException {
        String sql = "UPDATE books SET price = ?, author = ? WHERE title = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, book.getPrice());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getTitle());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("No book found with title: " + book.getTitle());
            }
            System.out.println("Book updated successfully");
        } catch (SQLException e) {
            throw new SQLException("Error updating book in database", e);
        }
    }

    public void deleteBook(String title) throws SQLException {
        String sql = "DELETE FROM books WHERE title = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("No book found with title: " + title);
            }
            System.out.println("Book deleted successfully");
        } catch (SQLException e) {
            throw new SQLException("Error deleting book from database", e);
        }
    }

}




