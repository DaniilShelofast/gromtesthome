package lesson35.controller;

import lesson35.dao.UserDAO;
import lesson35.model.User;
import lesson35.service.UserService;

import java.util.LinkedList;

public class UserController {

    private UserService userService = new UserService();

    public User registerUser(User user) {
        return userService.registerUser(user);
    }
}
