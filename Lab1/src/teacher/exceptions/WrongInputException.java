package teacher.exceptions;

public class WrongInputException extends RuntimeException {
    public WrongInputException() {
        super("wrong input");
    }
}
