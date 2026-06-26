package e3_4;

import java.io.*;

class Student implements Serializable {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age=age;
    }
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age +"}";
    }
}

// Course class
class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;

    public Course(String code, String name, String instructor) {
        this.courseCode = code;
        this.courseName = name;
        this.instructor = instructor;
    }
    public String toString() {
        return "Course{code=" + courseCode + ", name='" + courseName + "', instructor='" + instructor + "'}";
    }
}

// Enrollment class
class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(Student student, Course course, String date) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = date;
    }
    public String toString() {
        return "Enrollment{student=" + student + ", course=" + course + ", date='" + enrollmentDate + "'}";
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Student s = new Student(1, "Alice",100);
        Course c = new Course("Programming Project", "Intro to Simulation", "Dr. Dai");
        Enrollment e = new Enrollment(s, c, "2026-01-15");

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enrollments.ser"))) {
            oos.writeObject(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enrollments.ser"))) {
            Enrollment deserialized = (Enrollment) ois.readObject();
            System.out.println("Deserialized: " + deserialized);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

