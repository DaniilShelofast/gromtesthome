package lesson35.service;

import lesson35.model.User;

import java.io.IOException;

import static lesson35.dao.UserDAO.userDAO;


public class UserService {

    public final static UserService userService = new UserService();

    public void registerUser(User user) throws Exception {
        userDAO.verify(user.getId());
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
