public class DataLengthException extends RuntimeException {
     public DataLengthException(String message, Exception e){
         super(message, e);
     }

    public DataLengthException(Exception e){
        super("Wrong data quantity", e);
    }

    public DataLengthException() {
        super("Wrong data quantity");
    }

    public DataLengthException(String message) {
         super(message);
    }
}
