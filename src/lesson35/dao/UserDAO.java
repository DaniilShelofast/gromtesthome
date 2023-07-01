package lesson35.dao;


import lesson35.model.UserType;
import lesson35.model.User;

import java.io.*;
import java.util.LinkedList;

public class UserDAO extends GeneralDAO<User> {

    @Override
    public void addObjectToFile(User user) {
        txtPath("C:\\Users\\User\\Desktop/UserDb.txt");
        super.addObjectToFile(user);
    }

    public static void logout() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\User\\Desktop/UserDb.txt");
        file.close();
    }

    @Override
    public LinkedList<User> recordObject(LinkedList<String> strings) {
        LinkedList<User> users = new LinkedList<>();
        for (String line : strings) {
            String[] data = line.split(", ");
            if (data.length == 5) {
                users.add(new User(Integer.parseInt(data[0]), data[1], data[2], data[3], UserType.valueOf(data[4])));
            }
        }
        return users;
    }

    @Override
    public LinkedList<String> readFileText() {
        txtPath("C:\\Users\\User\\Desktop/UserDb.txt");
        return super.readFileText();
    }

}
