package hello;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSubjects;

        try {
            System.out.print("Enter number of subjects: ");
            numSubjects = scanner.nextInt();

            if (numSubjects <= 0) {
                System.out.println("Number of subjects must be positive.");
                return;
            }

            int[] marks = new int[numSubjects];
            int total = 0;

            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + " (0-100): ");
                int mark = scanner.nextInt();

                if (mark < 0 || mark > 100) {
                    throw new IllegalArgumentException("Invalid marks. Must be between 0 and 100.");
                }

                marks[i] = mark;
                total += mark;
            }

            double average = total / (double) numSubjects;
            char grade;

            if (average >= 90) grade = 'A';
            else if (average >= 80) grade = 'B';
            else if (average >= 70) grade = 'C';
            else if (average >= 60) grade = 'D';
            else grade = 'F';

            System.out.println("\n--- Result ---");
            System.out.println("Total Marks: " + total);
            System.out.printf("Average: %.2f\n", average);
            System.out.println("Grade: " + grade);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e);
        } finally {
            scanner.close();
        }
    }
}
