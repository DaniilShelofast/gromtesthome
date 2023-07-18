package lesson35.exception;

import java.io.IOException;

public class DataWritingException extends InternalServerException {
    public DataWritingException(String message, IOException e) {
        super(message);
    }
}
