package lesson35.service;

import lesson35.dao.UserDAO;
import lesson35.model.User;

import java.io.IOException;



public class UserService {

    public static void registerUser(User user) throws Exception {
        UserDAO userDAO = new UserDAO();
        userDAO.verify(user.getId());
        userDAO.addObjectToFile(user);
    }

    public static void logout() throws IOException {
        UserDAO.logout();
    }

    public static void login(String userName, String password) throws Exception {
        UserDAO dao = new UserDAO();
        User user = null;
        for (User u : dao.readAll()) {
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
}
