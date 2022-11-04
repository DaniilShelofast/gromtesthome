package lesson15Home;

import java.util.Arrays;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User findById(long id) {
        for (User it : users) {
            if (it != null && id == it.getId()) {
                return it;
            }
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && id == users[i].getId()) {
                users[i] = null;
            }
        }

    }


    public User upDate(User user) {

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && user.equals(users[i])) {
                users[i] = user;
                return user;
            }
        }

        return null;

    }


    public User save(User user) {
        User findById = findById(user.getId());
        if (findById != null) {
            return null;
        } else {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
            return null;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRepository that = (UserRepository) o;
        return Arrays.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(users);
    }
}
