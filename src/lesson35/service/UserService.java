package lesson35.service;

import lesson35.dao.UserDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.User;

import java.io.IOException;

import static lesson35.dao.UserDAO.readUsers;

public class UserService {

    public static void registerUser(User user) throws Exception {
        findUserId(user.getId());
        UserDAO.registerUser(user);
    }

    public static void login(String userName, String password) throws Exception {
        UserDAO.login(userName, password);
    }

    public static void logout() throws IOException {
        UserDAO.logout();
    }
    private static boolean findUserId(long id) throws Exception {
        for (User user : readUsers()) {
            if (user.getId() == id) {
                throw new BadRequestException("Error");
            }
        }
        return true;
    }
}
