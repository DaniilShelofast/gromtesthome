package lesson35.service;

import lesson35.dao.UserDAO;
import lesson35.model.User;

import java.io.IOException;


public class UserService {

    public final UserDAO userDAO = new UserDAO();

    public void registerUser(User user) throws Exception {
        userDAO.addObjectToFile(user);
    }

    public void logout() throws IOException {
        userDAO.logout();
    }

    public void login(String userName, String password) throws Exception {
        User user = null;
        for (User u : userDAO.readAll()) {
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
