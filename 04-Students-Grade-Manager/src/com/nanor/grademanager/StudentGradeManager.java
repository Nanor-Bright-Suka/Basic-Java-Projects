package src.com.nanor.grademanager;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<StudentInfo> students = new ArrayList<>();

        System.out.print("How many students do you want to enter? ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter details for student " + (i + 1));

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter Math Grade: ");
            double math = scanner.nextDouble();

            System.out.print("Enter English Grade: ");
            double english = scanner.nextDouble();

            System.out.print("Enter Science Grade: ");
            double science = scanner.nextDouble();
            scanner.nextLine(); // consume leftover newline

            // Create StudentGrade object and add to ArrayList
            students.add(new StudentInfo(name, id, math, english, science));
            System.out.println("Student added successfully!\n");
        }

        // Print list of students with name + average
        System.out.println("===== Student List (Name & Average) =====");
        for (StudentInfo student : students) {
            System.out.println(student.getName() + " - Average: " + student.average()
            );
        }

        scanner.close();

    }
}