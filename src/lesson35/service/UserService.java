package lesson35.service;

import lesson35.dao.UserDAO;
import lesson35.model.User;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) {
        return userDAO.registerUser(user);
    }
}
