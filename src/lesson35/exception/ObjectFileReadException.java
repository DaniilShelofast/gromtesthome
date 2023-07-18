package lesson35.exception;

import java.io.IOException;

public class ObjectFileReadException extends InternalServerException {
    public ObjectFileReadException(String message, IOException cause) {
        super(message);
    }
}
