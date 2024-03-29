package lesson35.dao;


import lesson35.exception.DataWritingException;
import lesson35.exception.ObjectConvertingException;
import lesson35.model.User;
import lesson35.model.UserType;

import java.util.LinkedList;

public class UserDAO extends GeneralDAO<User> {

    @Override
    public String getPath() {
        return "C:\\Users\\User\\Desktop/UserDb.txt";
    }

    @Override
    public void addObjectToFile(User user) throws DataWritingException {
        super.addObjectToFile(user);
    }

    @Override
    public LinkedList<User> readAll() throws Exception {
        return super.readAll();
    }

    @Override
    public User convert(String string) throws ObjectConvertingException {
        String[] data = string.split(", ");
        if (data.length == 5) {
            return new User(Long.parseLong(data[0]), data[1], data[2], data[3], UserType.valueOf(data[4]));
        }
        throw new ObjectConvertingException("Database error");
    }

}
