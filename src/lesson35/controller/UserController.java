package lesson35.controller;

import lesson35.model.User;

import java.io.IOException;

import static lesson35.service.UserService.userService;

public class UserController {

    public static void registerUser(User user) throws Exception {
        userService.registerUser(user);
    }

    public void login(String userName, String password) throws Exception {
        userService.login(userName, password);
    }

    public static void logout() throws IOException {
        userService.logout();
    }
}
