import java.text.ParseException;

public class WrongPhoneNumberException extends NumberFormatException {
    public WrongPhoneNumberException() {
        super("You have entered wrong format of phone number");
    }

    public WrongPhoneNumberException(String message) {
        super(message);
    }
}
