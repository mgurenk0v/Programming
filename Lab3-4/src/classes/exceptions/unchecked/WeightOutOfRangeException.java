package classes.exceptions.unchecked;

public class WeightOutOfRangeException extends RuntimeException {
    public WeightOutOfRangeException(String message) {
        super(message);
    }
}
