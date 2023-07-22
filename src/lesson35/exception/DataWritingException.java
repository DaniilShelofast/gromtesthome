package lesson35.exception;

public class DataWritingException extends InternalServerException {
    public DataWritingException(String message, Exception e) {
        super(message, e);
    }
}
