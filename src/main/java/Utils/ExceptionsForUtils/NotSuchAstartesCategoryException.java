package Utils.ExceptionsForUtils;
/**
 * Exception will be thrown if there was not such enum value
 */
public class NotSuchAstartesCategoryException extends RuntimeException{
    /**
     * constructor
     * @param message
     */
    public NotSuchAstartesCategoryException(String message){
        super(message);
    }
}
