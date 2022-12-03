package lesson20.task1.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String massage) {
        super(massage);
    }
}
