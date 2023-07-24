package lesson35.demo;

import lesson35.controller.UserController;
import lesson35.model.User;
import lesson35.model.UserType;

public class DemoUser {
    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();
        User user = new User("jjj", "eee", "null", UserType.USER);
        userController.registerUser(user);
    }
}
