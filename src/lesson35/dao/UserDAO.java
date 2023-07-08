package lesson35.dao;


import lesson35.exception.BadRequestException;
import lesson35.model.UserType;
import lesson35.model.User;

import java.io.*;
import java.util.LinkedList;

public class UserDAO extends GeneralDAO<User> {

    @Override
    public String getPath() {
        return "C:\\Users\\User\\Desktop/UserDb.txt";
    }

    @Override
    public void addObjectToFile(User user) {
        super.addObjectToFile(user);
    }

    public static void logout() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\User\\Desktop/UserDb.txt");
        file.close();
    }

    @Override
    public LinkedList<User> readAll() throws Exception {
        LinkedList<User> users = new LinkedList<>();
        for (String s : readFile()) {
            users.add(convert(s));
        }
        return users;
    }

    @Override
    public User convert(String string) throws BadRequestException {
        String[] data = string.split(", ");
        if (data.length == 5) {
            return new User(Integer.parseInt(data[0]), data[1], data[2], data[3], UserType.valueOf(data[4]));
        }
        throw new BadRequestException("Error : not a correct reading object.");
    }

}
