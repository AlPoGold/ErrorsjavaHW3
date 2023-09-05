public class WorkFileException extends RuntimeException{
    public WorkFileException() {
        super("Error with file");
    }

    public WorkFileException(String message) {
        super(message);
    }
}
