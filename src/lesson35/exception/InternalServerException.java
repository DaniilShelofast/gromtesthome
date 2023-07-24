package lesson35.exception;

public class InternalServerException extends Exception {
    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }
    public InternalServerException(String message) {
        super(message);
    }

}
