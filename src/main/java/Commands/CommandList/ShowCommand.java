package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.InappropriateArgForCommandException;
/**
 *One of the commands that extends abstract Command class to
 * implement execute method
 */
public class ShowCommand extends Command {
    public ShowCommand(){
        this.name = "show";
        this.info = "prints all the elements";
    }

    /**
     * execute command show
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     */
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException {

        if(args.length>1){
            throw new InappropriateArgForCommandException("This command doesn't have any arguments ");

        }else {commandHandle.executeShow();}
    }
}
