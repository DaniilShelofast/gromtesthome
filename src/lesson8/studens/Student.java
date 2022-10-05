package lesson8.studens;

import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    int group;
    Course[] coursesTaken;

    int age;



    public Student(String firstName, String lastName, int group, Course[] coursesTaken, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.coursesTaken = coursesTaken;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group=" + group +
                ", coursesTaken=" + Arrays.toString(coursesTaken) +
                ", age=" + age +
                '}';
    }
}
