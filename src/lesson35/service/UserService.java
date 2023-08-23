package lesson35.service;

import lesson35.dao.UserDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.User;

import static lesson35.model.Session.loggedInUser;
import static lesson35.service.ValidationUtils.checkContentAndNull;

public class UserService {

    public final UserDAO userDAO = new UserDAO();

    public void login(String userName, String password) throws Exception {
        User user = findUserPasswordAndUserName(userName, password);
        System.out.println("Login accepted." + "\n" + user);
        loggedInUser = user;
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("User exit from the system.");
    }

    public void registerUser(User user) throws Exception {
        validateUser(user);
        userDAO.addObjectToFile(user);
    }

    private void validateUser(User user) throws Exception {
        if (checkContentAndNull(user.getPassword()) || checkContentAndNull(user.getUserName()) || checkContentAndNull(user.getCountry()) || user.getUserType() == null) {
            throw new BadRequestException("Error, the entered data is incomplete, fill in each specified field.");
        }

        for (User u : userDAO.readAll()) {
            if (u.getUserName().equals(user.getUserName())) {
                throw new BadRequestException("Error: user with this login already exists, enter another login to complete registration");
            }
        }
    }

    private User findUserPasswordAndUserName(String userName, String password) throws Exception {
        for (User user : userDAO.readAll()) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new BadRequestException("this user does not exist, or the data is not correct");
    }

}
