package lesson35.dao;


import lesson35.model.UserType;
import lesson35.model.User;

import java.io.*;
import java.util.LinkedList;

public class UserDAO {

    public static void registerUser(User user)  {
        GeneralDAO.addObjectToFile(user,"C:\\Users\\User\\Desktop//UserDb.txt");
    }

    public static void logout() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\User\\Desktop//UserDb.txt");
        file.close();
    }

    public static LinkedList<User> recordObjectUser(LinkedList<String> strings) {
        LinkedList<User> users = new LinkedList<>();
        for (String line : strings) {
            String[] data = line.split(", ");
            if (data.length == 5) {
                users.add(new User(Integer.parseInt(data[0]), data[1], data[2], data[3], UserType.valueOf(data[4])));
            }
        }
        return users;
    }

    public static LinkedList<String> readFileTextUsers() {
        String line;
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop//UserDb.txt"))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
