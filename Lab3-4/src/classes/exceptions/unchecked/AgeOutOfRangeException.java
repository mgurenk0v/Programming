package classes.exceptions.unchecked;

public class AgeOutOfRangeException extends RuntimeException {
    public AgeOutOfRangeException(String message) {
        super(message);
    }
}
