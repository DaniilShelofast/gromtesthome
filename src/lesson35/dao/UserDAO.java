package lesson35.dao;


import lesson35.UserType;
import lesson35.model.User;

import java.io.*;
import java.util.LinkedList;

public class UserDAO {

    private static final String fileName = "C:\\Users\\User\\Desktop//UserDb.txt";

    private static LinkedList<User> readUsers() {
        LinkedList<User> users = new LinkedList<>();
        String[] data;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                data = line.split(", ");
                if (data.length >= 5) {
                    try {
                        int id = Integer.parseInt(data[0]);
                        String userName = data[1];
                        String password = data[2];
                        String country = data[3];
                        UserType userType = UserType.valueOf((data[4]));
                        users.add(new User(id, userName, password, country, userType));
                    } catch (Exception e) {
                        System.err.println("Error: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void login(String userName, String password) throws Exception {
        User user = null;
        for (User u : readUsers()) {
            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                user = u;
            }
        }

        if (user == null) {
            throw new Exception("Error.");
        }

        if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
            System.out.println("Login accepted");
        } else {
            System.err.println("Error : the specified data is incorrect");
        }

    }


    public static void registerUser(User user) throws Exception {
        findUserId(user.getId());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            File file = new File(fileName);
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
        FileInputStream file = new FileInputStream(fileName);
        file.close();
    }

    private static boolean findUserId(long id) throws Exception {
        for (User user : readUsers()) {
            if (user.getId() == id) {
                throw new Exception("Error");
            }
        }
        return true;
    }

}
