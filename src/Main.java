import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
 public class Main {
     public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TodoService service = new TodoService();

        while (true) {
            System.out.println("\n--- TODO APP ---");
            System.out.println("1. Create Todo");
            System.out.println("2. List Todos");
            System.out.println("3.Delete Todos");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();
            
            switch (input) {
                case "1":
                    String title = promptForTitle(scanner);
                    String description = promptForDescription(scanner);
                    try {
                        service.createTodo(title, description);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    List<Todo> todos = service.listTodos();
                    if (todos.isEmpty()) {
                        System.out.println("No todos yet.");
                    } else {
                        System.out.println("Your todos:");
                        for (int i = 0; i < todos.size(); i++) {
                            System.out.printf("%d. %s - %s%n", i + 1,
                                    todos.get(i).getTitle(),
                                    todos.get(i).getDescription());
                        }
                    }
                    break;
                case "3":
                    List<Todo> todoToDelete = service.listTodos();
                    if (todoToDelete.isEmpty()) {
                        System.out.println("No todos to delete.");
                        break;
                    }
                    System.out.println("Available Todos:");
                    for (int i = 0; i < todoToDelete.size(); i++) {
                        int number = i + 1;
                        Todo todo = todoToDelete.get(i);
                        System.out.printf("%d. %s - %s%n", number, todo.getTitle(), todo.getDescription());
                    }

                    System.out.print("Enter the number of the todo to delete (or 0 to cancel): ");

                    int deleteId;
                    try {
                        deleteId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        continue;
                    }

                    if (deleteId == 0) {
                        System.out.println("Todo deletion canceled.");
                        break;
                    }

                    if (deleteId < 1 || deleteId > todoToDelete.size()) {
                        System.out.println("Invalid number. Please try again.");
                        continue;
                    }

                    Todo todosAboutToDelete = todoToDelete.get(deleteId - 1);
                    service.deleteTodo(todosAboutToDelete);
                    continue;
                case "4":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        }
    }


            private static String promptForTitle(Scanner scanner) {
                while (true) {
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine().trim();

                    String err = validateTitle(title);
                    if (err == null) {
                        return title; // valid
                    } else {
                        System.err.println("Invalid title: " + err );
                    }
                }
            }


            private static String promptForDescription(Scanner scanner) {
                while (true) {
                    System.out.println("Enter description: ");
                    String description = scanner.nextLine().trim();

                    String err = validateDescription(description);
                    if (err == null) {
                        return description; // valid
                    } else {
                        System.err.println("Invalid description: \n" + err );
                    }
                }
            }



            // Returns null if valid, otherwise an error message
            private static String validateTitle(String title) {
                if (title.isEmpty()) {
                    return "Title cannot be empty.";
                }

                if (!title.matches("[a-zA-Z0-9 \\-_.]+")) {
                    return "Title contains disallowed characters.";
                }

                if (title.toLowerCase().matches(".*(select\\s+.*from|drop\\s+table).*")) {
                    return "Description contains suspicious content.";
                }
                return null;
            }

            private static String validateDescription(String desc) {
                if (desc.isEmpty()) {
                    return "Description cannot be empty.";
                }

                if (!desc.matches("[a-zA-Z0-9 \\-_.']+")) {
                    return "Description contains disallowed characters.";
                }

                // Example: forbid SQL-like injection patterns (very basic)
                if (desc.toLowerCase().matches(".*(select\\s+.*from|drop\\s+table).*")) {
                    return "Description contains suspicious content.";
                }
                return null;
            }



 }




