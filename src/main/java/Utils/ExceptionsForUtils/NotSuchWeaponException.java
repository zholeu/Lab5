package Utils.ExceptionsForUtils;
/**
 * Exception will be thrown if there was not such enum value
 */
public class NotSuchWeaponException extends RuntimeException{
    /**
     * constructor
     * @param message
     */
    public NotSuchWeaponException(String message){
        super(message);
    }

}
