package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.InappropriateArgForCommandException;
import java.io.IOException;

/**
 *One of the commands that extends abstract Command class to
 * implement execute method
 */

public class ClearCommand  extends Command {

    public ClearCommand(){
        this.name = "clear";
        this.info = "clears the collection";
    }

    /**
     *execute command clear
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     * @throws IOException
     */
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {

        if(args.length>1){
            throw new InappropriateArgForCommandException("This command doesn't have any arguments ");

        }else {commandHandle.executeClear();}
    }
}
