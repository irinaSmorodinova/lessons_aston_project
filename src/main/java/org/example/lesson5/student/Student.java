package org.example.lesson5.student;

import java.util.List;
import java.util.Map;

public class Student {
    private final String name;
    private final String group;
    private int course;
    private final Map<String, List<Integer>> grades;

    public Student(String name, String group, int course, Map<String, List<Integer>> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        return grades.values().stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }
}