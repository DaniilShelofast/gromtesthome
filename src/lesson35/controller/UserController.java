package lesson35.controller;

import lesson35.model.User;
import lesson35.service.UserService;

import java.io.IOException;

public class UserController {

    public static void registerUser(User user) throws Exception {
        UserService.registerUser(user);
    }

    public static void login(String userName, String password) throws Exception {
        UserService.login(userName, password);
    }

    public static void logout() throws IOException {
        UserService.logout();
    }
}
