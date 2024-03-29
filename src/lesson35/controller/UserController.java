package lesson35.controller;

import lesson35.model.User;
import lesson35.service.UserService;

public class UserController {

    private final UserService userService = new UserService();

    public void registerUser(User user) throws Exception {
        userService.registerUser(user);
    }

    public void login(String userName, String password) throws Exception {
        userService.login(userName, password);
    }

    public void logout() throws Exception {
        userService.logout();
    }
}
