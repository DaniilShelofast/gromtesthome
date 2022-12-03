package lesson20.task1;


import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {

        this.users = users;
    }

    public User[] getUsers() {

        return users;
    }

    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can`t save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return user;
            }
        }

        throw new InternalServerException("Not space to save user with id: " + user.getId());
    }


    public User upDate(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can`t save null user");

        for (int i = 0; i < users.length; i++) {
            if (user.getId() == users[i].getId()) {
                users[i] = user;
                return user;
            }

        }
        throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws Exception {

        findById(id);

        for (int i = 0; i < users.length; i++) {
            if (id == users[i].getId()) {
                users[i] = null;
                break;
            }
        }

    }

    public User findById(long id) throws UserNotFoundException {
        for (User it : users) {
            if (it != null && id == it.getId()) {
                return it;
            }
        }
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

}
