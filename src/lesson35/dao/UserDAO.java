package lesson35.dao;


import lesson35.UserType;
import lesson35.model.User;

import java.io.*;
import java.util.LinkedList;

public class UserDAO {

    public static void login(String userName, String password) throws Exception {
        User user = null;
        for (User u : readUsers()) {
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


    public static void registerUser(User user) throws Exception {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop//UserDb.txt", true))) {
            File file = new File("C:\\Users\\User\\Desktop//UserDb.txt");
            if (file.length() == 0) {
                writer.write(user.getId() + ", " + user.getUserName() + ", " + user.getPassword() + ", " + user.getCountry() + ", " + user.getUserType());
            } else {
                writer.newLine();
                writer.write(user.getId() + ", " + user.getUserName() + ", " + user.getPassword() + ", " + user.getCountry() + ", " + user.getUserType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logout() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\User\\Desktop//UserDb.txt");
        file.close();

    }

    public static LinkedList<User> readUsers() {
        LinkedList<User> users = new LinkedList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop//UserDb.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 5) {
                    users.add(new User(Integer.parseInt(data[0]), data[1], data[2], data[3], UserType.valueOf(data[4])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
