package com.nanor.todoapp;

public class Todo {
    private final String title;
    private final String description;

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }

}
