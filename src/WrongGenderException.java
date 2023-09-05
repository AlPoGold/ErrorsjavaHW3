public class WrongGenderException extends RuntimeException{
    public WrongGenderException() {
        super("You have entered wrong gender");
    }

    public WrongGenderException(String message) {
        super(message);
    }
}
