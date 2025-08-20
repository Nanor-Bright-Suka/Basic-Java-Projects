package com.nanor.todoapp;

import java.util.ArrayList;
import java.util.List;

// Service responsible for managing todos

 public class TodoService {
    private final List<Todo> todos = new ArrayList<>();

    public void createTodo(String title, String description) {
        Todo todo = new Todo(title, description);
        todos.add(todo);
        System.out.println("com.nanor.todoapp.Todo is created successfully");
    }

   public void deleteTodo(Todo todo){
        if(todos.remove(todo)){;
       System.out.println("com.nanor.todoapp.Todo deleted Successfully");
       }else{
            System.out.println("Delete is unsuccessful");
        }
   }

    public List<Todo> listTodos() {
        return new ArrayList<>(todos);
    }
}