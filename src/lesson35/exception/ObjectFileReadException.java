package lesson35.exception;

public class ObjectFileReadException extends InternalServerException {
    public ObjectFileReadException(String message, Throwable exception) {
        super(message, exception);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
