package Utils.ExceptionsForUtils;
/**
 * Exception will be thrown if while execution of script there
 * was an Inappropriate value
 */
public class InappropriateInputException extends RuntimeException{
    /**
     * constructor
     * @param message
     */
    public InappropriateInputException(String message){
        super(message);
    }

}
