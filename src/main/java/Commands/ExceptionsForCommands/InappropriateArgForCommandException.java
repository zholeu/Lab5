package Commands.ExceptionsForCommands;

/**
 * Exception will be thrown if command is not supposed to have an argument
 */
public class InappropriateArgForCommandException extends RuntimeException{
    /**
     * constructor
     * @param message
     */
        public InappropriateArgForCommandException(String message){
            super(message);
        }
    }

