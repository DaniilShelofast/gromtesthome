package lesson35.service;

import lesson35.dao.UserDAO;
import lesson35.model.User;

import java.io.IOException;

public class UserService {

    public static void registerUser(User user) throws Exception {
        UserDAO.registerUser(user);
    }

    public static void login(String userName, String password) throws Exception {
        UserDAO.login(userName, password);
    }

    public static void logout() throws IOException {
        UserDAO.logout();
    }
}
