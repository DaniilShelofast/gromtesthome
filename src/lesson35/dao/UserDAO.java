package lesson35.dao;


import lesson35.model.User;

import java.util.LinkedList;

public class UserDAO {

    private static final LinkedList<User> users = new LinkedList<>();

    public UserDAO() {
    }

    public User registerUser(User user) {
        return user;
    }

    public static LinkedList<User> getUsers() {
        return users;
    }

}
