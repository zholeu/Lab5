package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.InappropriateArgForCommandException;
/**
 *One of the commands that extends abstract Command class to
 * implement execute method
 */
public class PrintDescendingCommand  extends Command {
    public PrintDescendingCommand(){
        this.name = "print_descending";
        this.info = "prints elements in descending order";
    }

    /**
     * execute command print_descending
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     */
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException {

        if(args.length>1){
            throw new InappropriateArgForCommandException("This command doesn't have any arguments ");

        }else {commandHandle.executePrintDescending();}
    }
}
