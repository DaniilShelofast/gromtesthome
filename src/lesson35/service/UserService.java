package lesson35.service;

import lesson35.dao.UserDAO;
import lesson35.model.User;

import java.io.IOException;

import static lesson35.dao.UserDAO.readFileTextUsers;
import static lesson35.dao.UserDAO.recordObjectUser;

public class UserService extends GeneralService<User> {

    public static void registerUser(User user) throws Exception {
        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService();
        userService.verificationObjectID(user.getId());
        userDAO.addObjectToFile(user);
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

    @Override
    protected boolean verificationObjectID(long id) throws Exception {
        setReadFile(recordObjectUser(readFileTextUsers()));
        return super.verificationObjectID(id);
    }

    @Override
    public User findIdObject(long id) throws Exception {
        setReadFile(recordObjectUser(readFileTextUsers()));
        return super.findIdObject(id);
    }
}
