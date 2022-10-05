package lesson8.studens;


import java.util.Arrays;
import java.util.Date;

public class Course {
    Date startDate;
    String name;
    int hoursDuration;
    String teacherName;
    Student[] students;

    public Course(Date startDate, String name, int hoursDuration, String teacherName, Student[] students) {
        this.startDate = startDate;
        this.name = name;
        this.hoursDuration = hoursDuration;
        this.teacherName = teacherName;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "startDate=" + startDate +
                ", name='" + name + '\'' +
                ", hoursDuration=" + hoursDuration +
                ", teacherName='" + teacherName + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
