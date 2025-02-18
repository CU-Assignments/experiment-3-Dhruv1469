/*
Hard Level
Problem Statement: Create a Java program for a university enrollment system with exception handling. The program should:

Allow students to enroll in courses.
Throw a CourseFullException if the maximum enrollment limit is reached.
Throw a PrerequisiteNotMetException if the student hasn’t completed prerequisite courses.

Input Example:
Enroll in Course: Advanced Java
Prerequisite: Core Java
Status: Prerequisite not completed
Output Example:
Error: PrerequisiteNotMetException - Complete Core Java before enrolling in Advanced Java.

*/
import java.util.HashMap;
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class exp33 {
    private static final int MAX_ENROLLMENT = 2;
    private static int enrolledStudents = 0;
    private static final HashMap<String, Boolean> prerequisites = new HashMap<>();

    static {
        prerequisites.put("Advanced Java", false);  // Prerequisite Core Java not completed
    }

    public static void enrollStudent(String course) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents >= MAX_ENROLLMENT) {
            throw new CourseFullException("Error: CourseFullException - Enrollment limit reached.");
        }

        if (prerequisites.containsKey(course) && !prerequisites.get(course)) {
            throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete Core Java before enrolling in Advanced Java.");
        }

        enrolledStudents++;
        System.out.println("Enrollment successful for " + course);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enroll in Course: ");
        String course = scanner.nextLine();

        try {
            enrollStudent(course);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
