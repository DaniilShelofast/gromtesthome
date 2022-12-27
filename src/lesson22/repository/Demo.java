package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User user1 = new User(1001, "Oleg", "one2345");
        User user2 = new User(1651, "Sasha", "one2345");
        User user3 = new User(16, "Sasha", "one2345");
        UserRepository.save(user1);
        UserRepository.save(user2);
        UserRepository.save(user3);


        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

    }
}
