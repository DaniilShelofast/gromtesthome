package lesson8.studens;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Student result = createHighestParent();
        System.out.println(result);
        Student res = createLowestChild();
        System.out.println(res);
    }


    static Student createHighestParent() {
        Student[] students = new Student[1];

        Course[] courses = new Course[2];

        courses[0] = new Course(new Date(), "Max", 123, "Larysa", students);

        Course course = new Course(new Date(), "Igor", 123, "Larysa", students);
        courses[1] = course;


        Student student = new Student("Ivan", "Ivanov", 12, courses, 10);
        //  students[0] = student;

        return student;

    }

    static SpecialStudent createLowestChild() {
        SpecialStudent[] specialStudent1 = new SpecialStudent[1];

        Course[] courses = new Course[2];

        courses[0] = new Course(new Date(), "Max", 123, "Larysa", specialStudent1);
        Course course = new Course(new Date(), "Igor", 123, "Larysa", specialStudent1);
        courses[1] = course;


        SpecialStudent specialStudent = new SpecialStudent("Ivan", "Ivanov", 12, courses, 10, 1234, "email");
        // specialStudent1[0] = specialStudent;

        return specialStudent;

    }


}