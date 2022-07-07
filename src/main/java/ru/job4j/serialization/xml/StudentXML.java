package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentXML {
    @XmlAttribute
    private boolean isStudent;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private String name;
    @XmlElement
    private FacultyXML faculty;
    @XmlElementWrapper(name = "exams")
    @XmlElement(name = "exam")
    private String[] exam;

    public StudentXML() {
    }

    public StudentXML(boolean isStudent, int age, String name, FacultyXML faculty, String[] exam) {
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
