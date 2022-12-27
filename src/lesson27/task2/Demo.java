package lesson27.task2;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<UserDAO> arrayList = new ArrayList<>();
        User user1 = new User(1001, "Oleg", "one2345");
        User user2 = new User(1651, "Sasha", "one2345");



        System.out.println(UserDAO.getUsers());


    }
}
