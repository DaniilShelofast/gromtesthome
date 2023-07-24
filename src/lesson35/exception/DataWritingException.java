package lesson35.exception;

public class DataWritingException extends InternalServerException {
    public DataWritingException(String message, Throwable cause) {
        super(message, cause);
    }
}
