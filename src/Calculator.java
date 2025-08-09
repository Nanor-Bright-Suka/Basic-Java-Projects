import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Calculator{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Step 1: Show operator menu
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add (+)");
            System.out.println("2. Subtract (-)");
            System.out.println("3. Multiply (×)");
            System.out.println("4. Divide (÷)");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline


            if (choice == 5) {
                System.out.println("Goodbye!");
                break; // leaves while loop immediately
            }
//            if (choice >= 1 && choice <= 4) {
                List<Double> numbers = new ArrayList<>();
                System.out.println("Enter numbers one by one. Type 'done' when finished:");

                // Step 2: Read numbers until user types "done"
                while (true) {
                    String input = scanner.nextLine().trim();

                    if (input.equalsIgnoreCase("done")) {
                        break; // stop reading
                    }

                    try {
                        double num = Double.parseDouble(input);
                        numbers.add(num);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please enter a number or 'done'.");
                    }
                }

                // Step 3: Build expression and calculate
                if (!numbers.isEmpty()) {
                    double result = numbers.getFirst(); // start from first number
                    StringBuilder expression = new StringBuilder();
                    expression.append(numbers.getFirst());

                    for (int i = 1; i < numbers.size(); i++) {
                        switch (choice) {
                            case 1: // Addition
                                result += numbers.get(i);
                                expression.append(" + ");
                                break;
                            case 2: // Subtraction
                                result -= numbers.get(i);
                                expression.append(" - ");
                                break;
                            case 3: // Multiplication
                                result *= numbers.get(i);
                                expression.append(" × ");
                                break;
                            case 4: // Division
                                if (numbers.get(i) == 0) {
                                    System.out.println("Error: Division by zero is not allowed.");
                                    return;
                                }
                                result /= numbers.get(i);
                                expression.append(" ÷ ");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        expression.append(numbers.get(i));
                    }
                    // Step 4: Output
                    System.out.println(expression + " = " + result);
                } else {
                    System.out.println("No numbers entered.");
                }
//            }
            // Step 5: Ask if they want to restart
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String again = scanner.nextLine();
            if (!again.equalsIgnoreCase("yes")) {
                break; // exit loop and program
            }
        }
        scanner.close();
    }
}
