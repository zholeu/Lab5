package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.InappropriateArgForCommandException;
/**
 *One of the commands that extends abstract Command class to
 * implement execute method
 */
public class InsertAtElementCommand extends Command {
    public InsertAtElementCommand(){
        this.name="insert_at_element";
        this.info="insert at given position";
    }

    /**
     * execute command insert_at_element
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     * @throws NumberFormatException
     */
    public void execute(CommandHandle commandHandle, String args[]) throws InappropriateArgForCommandException,NumberFormatException{
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else {
            commandHandle.executeInsertAtElement(args[1]);
        }
    }
}
