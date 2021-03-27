package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.InappropriateArgForCommandException;
/**
 *One of the commands that extends abstract Command class to
 * implement execute method
 */
public class UpdateIdElementCommand extends Command {
    public UpdateIdElementCommand(){
        this.name="update";
        this.info="update the value of the collection item whose id is equal to the given";
    }

    /**
     * execute command update
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     * @throws NumberFormatException
     */
    public void execute(CommandHandle commandHandle, String args[]) throws InappropriateArgForCommandException,NumberFormatException{
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else {
            commandHandle.executeUpdateIdElement(args[1]);
        }
    }
}
