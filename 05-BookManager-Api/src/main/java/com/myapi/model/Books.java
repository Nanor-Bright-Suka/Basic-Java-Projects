package com.myapi.model;

public class Books {
    private String title;
    private String author;
    private double price;

    // Default constructor (needed for JSON parsing & frameworks)
    public Books() {}

    // Convenience constructor (optional)
    public Books(String title, double price ,String author) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return title + " by " + author + " ($" + price + ")";
    }
}

