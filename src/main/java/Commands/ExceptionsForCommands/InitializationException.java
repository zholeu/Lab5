package Commands.ExceptionsForCommands;
/**
 * Exception will be thrown if durind initialization there was an error
 */


public class InitializationException extends RuntimeException{
    /**
     * constructor
     * @param message
     */
    public InitializationException(String message){
        super(message);
    }
}

