package com.myapi.db;

import java.sql.*;


public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/bookmanagerdb";
    private static final String USER = "nanor";
    private static final String PASSWORD = "nanor415";


    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Re-throw the same SQLException with more context
            throw new SQLException("❌ Failed to connect to PostgreSQL database", e);
        }


    }

}