package mate.academy.internetshop.exceptions;

public class DataProcessingException extends RuntimeException {
    public DataProcessingException(String message, Throwable text) {
        super(message, text);
    }
}
