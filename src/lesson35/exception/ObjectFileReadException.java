package lesson35.exception;

public class ObjectFileReadException extends InternalServerException {
    public ObjectFileReadException(String message, Exception exception) {
        super(message, exception);
    }
}
