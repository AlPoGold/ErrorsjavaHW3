public class WrongLNPException extends RuntimeException{
    public WrongLNPException() {
        super("You have entered wrong part of your  whole name!");
    }

    public WrongLNPException(String arg) {
        super("You have entered wrong "+ arg + " !");
    }
}
