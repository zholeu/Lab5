package Commands.ExceptionsForCommands;


/**
 * Exception will be thrown  when set a value,which can't be null, as null
 */

public class NullException extends RuntimeException{
    public NullException(){
        super();
    }
    public NullException(String message){
        super(message);
    }
}

