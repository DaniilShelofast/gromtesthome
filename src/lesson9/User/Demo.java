package lesson9.User;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User[] users = new User[3];
        users[1] = new User(3, "Vlad", "one");
        users[2] = new User(2, "Sasha", "one");
        users[0] = new User(12, "Max", "one");
        UserRepository getUserNameById = new UserRepository(users);
        // System.out.println(Arrays.toString(getUserNameById.getUserNames()));
        // System.out.println(Arrays.toString(getUserNameById.getUserIds()));
        // System.out.println(getUserNameById.getUserNameById(1));

        //System.out.println(Arrays.deepToString(users));

        System.out.println(getUserNameById.upDate(new User(3, "Igor", "two")));
        System.out.println(Arrays.deepToString(users));

        //System.out.println(getUserNameById.save(new User(12, "Artem", "one")));
        //System.out.println(Arrays.deepToString(users));
       // System.out.println(getUserNameById.findById(3));


    }
}
