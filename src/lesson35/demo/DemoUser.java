package lesson35.demo;

import lesson35.controller.UserController;
import lesson35.model.User;
import lesson35.model.UserType;

public class DemoUser {
    public static void main(String[] args) throws Exception {
        User user = new User("ddd", "fff", "fff", UserType.USER);
        UserController.registerUser(user);
    }
}
