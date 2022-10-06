package lesson15Home;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User findById(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null &&  users[i].getId() == id) {
                return users[i];
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
            if (users[i] != null && user.getId() == users[i].getId()) {
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

}
