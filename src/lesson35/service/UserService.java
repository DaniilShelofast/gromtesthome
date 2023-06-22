package lesson35.service;

import lesson35.dao.UserDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.User;

import java.io.IOException;

import static lesson35.dao.UserDAO.readFileTextUsers;
import static lesson35.dao.UserDAO.recordObjectUser;

public class UserService {

    public static void registerUser(User user) throws Exception {
        checkIdUser(user.getId());
        UserDAO.registerUser(user);
    }
    public static void logout() throws IOException {
        UserDAO.logout();
    }

    public static void login(String userName, String password) throws Exception {
        User user = null;
        for (User u : recordObjectUser(readFileTextUsers())) {
            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                user = u;
            }
        }

        if (user == null) {
            throw new Exception("Error : the specified data is incorrect");
        } else {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                System.out.println("Login accepted." + "\n" + user);
            }
        }
    }

    private static boolean checkIdUser(long id) throws Exception {
        for (User user : recordObjectUser(readFileTextUsers())) {
            if (user.getId() == id) {
                throw new BadRequestException("Error : a user with this id already exists.");
            }
        }
        return true;
    }
    public static User findUserId(long idUser) {
        for (User user : recordObjectUser(readFileTextUsers())) {
            if (user.getId() == idUser) {
                return user;
            }
        }
        return null;
    }
}
