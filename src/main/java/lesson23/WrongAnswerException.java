package lesson23;

public class WrongAnswerException extends Exception {

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public WrongAnswerException() {
        super("Wrong number has been written");
    }
}
