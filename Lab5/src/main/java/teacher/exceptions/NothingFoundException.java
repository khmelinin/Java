package teacher.exceptions;

public class NothingFoundException extends RuntimeException {
    public NothingFoundException() {
        super("nothing was found");
    }
}