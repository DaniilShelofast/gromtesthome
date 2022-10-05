package lesson8.studens;

public class CollegeStudent extends Student {
    String collegeName;
    int rating;
    long id;

    public CollegeStudent(String firstName, String lastName, int group, Course[] coursesTaken,int age, String collegeName, int rating, long id) {
        super(firstName, lastName, group, coursesTaken, age);
        this.collegeName = collegeName;
        this.rating = rating;
        this.id = id;
    }

    public CollegeStudent(String firstName, String lastName, int group, Course[] coursesTaken, int age) {
        super(firstName, lastName, group, coursesTaken, age);
    }
}
