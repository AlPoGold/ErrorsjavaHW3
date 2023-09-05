public class WrongBirthDateException extends RuntimeException{

    public WrongBirthDateException(String message){
        super(message);
    }

    public WrongBirthDateException(){
        super("Tou have entered wrong format of birth date");
    }
}
