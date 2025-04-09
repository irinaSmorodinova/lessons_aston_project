package org.example.lesson5.student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Integer>> grades1 = new HashMap<>();
        grades1.put("Math", Arrays.asList(4, 3, 5));
        grades1.put("Physics", Arrays.asList(3, 3, 4));

        Map<String, List<Integer>> grades2 = new HashMap<>();
        grades2.put("Math", Arrays.asList(2, 2, 2));
        grades2.put("Physics", Arrays.asList(2, 2, 2));

        Map<String, List<Integer>> grades3 = new HashMap<>();
        grades3.put("Math", Arrays.asList(5, 5, 5));
        grades3.put("Physics", Arrays.asList(5, 5, 5));

        Student student1 = new Student("Alice", "A1", 1, grades1);
        Student student2 = new Student("Bob", "A1", 1, grades2);
        Student student3 = new Student("Charlie", "A1", 1, grades3);

        Set<Student> students = new HashSet<>(Arrays.asList(student1, student2, student3));

        System.out.println("Before removal:");
        students.forEach(System.out::println);

        StudentUtils.removeStudentsWithLowGrades(students);

        System.out.println("\nAfter removal:");
        students.forEach(System.out::println);

        StudentUtils.promoteStudents(students);

        System.out.println("\nAfter promotion:");
        students.forEach(System.out::println);

        System.out.println("\nStudents in course 2:");
        StudentUtils.printStudents(students, 2);
    }
}