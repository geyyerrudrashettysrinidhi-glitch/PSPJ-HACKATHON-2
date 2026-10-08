import java.util.Scanner;

class Student {
    // Data members
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized constructor
    Student(String studentName, int rollNumber, double marks,
            String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee
    double calculateFee() {
        return courseCredits * 1500;
    }

    // Check eligibility
    boolean checkEligibility() {
        return marks >= 50;
    }

    // Calculate scholarship percentage
    double calculateScholarship() {
        double fee = calculateFee();

        if (marks >= 85) {
            return fee * 0.20;
        } else if (marks >= 70) {
            return fee * 0.10;
        } else {
            return 0;
        }
    }

    // Calculate final fee
    double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Display all details
    void displayDetails() {
        System.out.println("\n===== STUDENT COURSE REGISTRATION =====");
        System.out.println("Student Name     : " + studentName);
        System.out.println("Roll Number      : " + rollNumber);
        System.out.println("Marks            : " + marks);
        System.out.println("Course Name      : " + courseName);
        System.out.println("Course Credits   : " + courseCredits);

        System.out.println("Eligibility      : Eligible");
        System.out.println("Total Fee        : Rs. " + calculateFee());
        System.out.println("Scholarship      : Rs. " + calculateScholarship());
        System.out.println("Final Fee        : Rs. " + calculateFinalFee());
    }
}

public class StudentCourseRegistration {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read student and course details
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        sc.nextLine(); // Consume newline

        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        System.out.print("Enter course credits: ");
        int credits = sc.nextInt();

        // Create object using parameterized constructor
        Student student = new Student(name, roll, marks, course, credits);

        // Check eligibility
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\n===== REGISTRATION STATUS =====");
            System.out.println("Student is not eligible for course registration.");
            System.out.println("Minimum required marks: 50");
        }

        sc.close();
    }
}