package lesson35.exception;

public class ObjectConvertingException extends InternalServerException {
    public ObjectConvertingException(String message, Throwable cause) {
        super(message, (Exception) cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
