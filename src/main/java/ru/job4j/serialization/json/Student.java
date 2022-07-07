package ru.job4j.serialization.json;

import java.util.Arrays;

public class Student {
    private final boolean isStudent;
    private final int age;
    private final String name;
    private final Faculty faculty;
    private final String[] exam;

    public Student(boolean isStudent, int age, String name, Faculty faculty, String[] exam) {
        this.isStudent = isStudent;
        this.age = age;
        this.name = name;
        this.faculty = faculty;
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "Student{"
                + "isStudent=" + isStudent
                + ", age=" + age
                + ", name=" + name
                + ", faculty=" + faculty
                + ", exam=" + Arrays.toString(exam)
                + '}';
    }
}
