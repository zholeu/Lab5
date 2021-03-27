package Commands.ExceptionsForCommands;

/**
 * Exception will be thrown if inserted value is too small
 */

public class ValueTooSmallException extends RuntimeException{

    /**
     * constructor
     * @param message
     */

    public ValueTooSmallException(String message){
        super(message);
    }
}
