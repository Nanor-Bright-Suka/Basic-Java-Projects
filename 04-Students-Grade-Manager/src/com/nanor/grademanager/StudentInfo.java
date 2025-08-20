package src.com.nanor.grademanager;

public class StudentInfo {
    // Fields (attributes)
    private final String name;
    private final String id;
    private final double mathGrade;
    private final double englishGrade;
    private final double scienceGrade;

    // Constructor
    public StudentInfo(String name, String id, double mathGrade, double englishGrade, double scienceGrade) {
        this.name = name;
        this.id = id;
        this.mathGrade = mathGrade;
        this.englishGrade = englishGrade;
        this.scienceGrade = scienceGrade;
    }

    // Method to calculate average
    public double average() {
        return (mathGrade + englishGrade + scienceGrade) / 3.0;
    }

    // Method to print full student info
    public void printInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Math Grade: " + mathGrade);
        System.out.println("English Grade: " + englishGrade);
        System.out.println("Science Grade: " + scienceGrade);
        System.out.println("Average: " + average());
        System.out.println("----------------------------");
    }

    // Getter (so we can access name outside)
    public String getName() {
        return name;
    }

}
