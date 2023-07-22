package lesson35.exception;

import java.io.IOException;

public class ObjectConvertingException extends InternalServerException {
    public ObjectConvertingException(String message, IOException e) {
        super(message);
    }
}
