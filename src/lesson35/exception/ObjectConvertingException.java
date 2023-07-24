package lesson35.exception;

public class ObjectConvertingException extends InternalServerException {
    public ObjectConvertingException(String message) {
        super(message);
    }

    public ObjectConvertingException(String message, Throwable cause) {
        super(message, cause);
    }
}
