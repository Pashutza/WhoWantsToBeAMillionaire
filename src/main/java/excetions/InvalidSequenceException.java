package excetions;

public class InvalidSequenceException extends Exception {
    public InvalidSequenceException(String message) {
        super(message);
    }
    public InvalidSequenceException(){
        super("Optiune invalida!");
    }
}
