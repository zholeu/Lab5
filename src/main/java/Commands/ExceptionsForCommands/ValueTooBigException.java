package Commands.ExceptionsForCommands;
/**
 * Exception will be thrown if inserted value is too big
 */
public class ValueTooBigException extends RuntimeException{
    /**
     * constructor
     * @param message
     */
    public ValueTooBigException(String message){
        super(message);
    }
}