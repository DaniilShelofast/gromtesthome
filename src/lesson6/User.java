package lesson6;

import java.util.Date;

public class User {
    String name;
    int age;
    String citi;
    Date lastActiveDate;
    boolean isActive;


    public User(String name, int age, String citi, Date lastActiveDate, boolean isActive) {
        this.name = name;
        this.age = age;
        this.citi = citi;
        this.lastActiveDate = lastActiveDate;
        this.isActive = isActive;
    }

    public User() {
    }

    void logIn() {
        lastActiveDate = new Date();
    }

    void isActive(boolean status) {
        isActive = status;
    }

    void increaseAge() {
        age++;
    }
}
