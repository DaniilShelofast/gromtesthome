package lesson35.exception;

public class InternalServerException extends Exception {
    public InternalServerException(String message, Exception exception) {
        super(message,exception);
    }
}
