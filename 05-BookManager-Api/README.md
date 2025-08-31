# 📚 BookManager REST API (Java + JDBC + PostgreSQL)

A simple REST API built in **pure Java (HttpServer)** without Spring Boot.  
It demonstrates how to connect to a **PostgreSQL** database using **JDBC** to manage books.

---

## 🚀 Features

- `GET /getbooks` → Fetch all books
- `POST /create-books` → Add a new book (JSON body)
- `PATCH /update-books` → Update an existing book (JSON body)
- `DELETE /delete-books` → Delete a book 
- Uses **JDBC** for database access
- Clean package structure:

# Folder Structure
  src/main/java/com/myapi/
  ├── Main.java # Starts the server
  ├── db/Database.java # Connection manager
  ├── db/BookRepository.java
  ├── handler/BooksHandler.java
  ├── model/Book.java


## 🛠 Requirements

- Java **21+**
- Maven
- PostgreSQL (running locally)

---

## ⚙️ Setup

### 1. Clone the repo
```bash
git clone https://github.com/your-username/bookmanager.git
cd bookmanager

## To run the project
mvn clean install
java -jar target/bookmanager-1.0-SNAPSHOT.jar
```
