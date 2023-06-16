package lesson35.demo;

import lesson35.model.UserType;
import lesson35.controller.UserController;
import lesson35.model.User;

import java.util.Random;

public class DemoUser {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        User user = new User(randomNumber,"fff","fff","fff", UserType.ADMIN);
        UserController.registerUser(user);
    }
}
