package lesson35.demo;

import lesson35.controller.UserController;
import lesson35.model.User;
import lesson35.model.UserType;

import static lesson35.dao.GeneralDAO.randomID;

public class DemoUser {
    public static void main(String[] args) throws Exception {
        User user = new User(randomID(), "fff", "fff", "fff", UserType.USER);
        UserController.registerUser(user);
    }
}
