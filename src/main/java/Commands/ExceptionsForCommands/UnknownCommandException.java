package Commands.ExceptionsForCommands;

/**
 * Exception will be thrown if there is no such command
 */

public class UnknownCommandException extends  RuntimeException{
    /**
     * constructor
     * @param message
     */
    public UnknownCommandException(String message){
        super(message);
    }

}
