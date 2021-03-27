package Commands.ExceptionsForCommands;

/**
 * Exception will be thrown when static vector SpaceMarine in collections  isn't initialized
 */
public class NotInitializationException extends RuntimeException{
    /**
     * constructor
     * @param message
     */
    public NotInitializationException(String message){
        super(message);
    }
}

