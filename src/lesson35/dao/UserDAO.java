package lesson35.dao;


import lesson35.exception.BadRequestException;
import lesson35.model.User;
import lesson35.model.UserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

public class UserDAO extends GeneralDAO<User> {

    public static final UserDAO userDAO = new UserDAO();

    @Override
    public String getPath() {
        return "C:\\Users\\User\\Desktop/UserDb.txt";
    }

    @Override
    public void addObjectToFile(User user) {
        super.addObjectToFile(user);
    }

    public void logout() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\User\\Desktop/UserDb.txt");
        file.close();
    }

    @Override
    public LinkedList<User> readAll() throws Exception {
        return super.readAll();
    }

    @Override
    public User convert(String string) throws BadRequestException {
        String[] data = string.split(", ");
        if (data.length == 5) {
            return new User(Long.parseLong(data[0]), data[1], data[2], data[3], UserType.valueOf(data[4]));
        }
        throw new BadRequestException("Database error");
    }

}
