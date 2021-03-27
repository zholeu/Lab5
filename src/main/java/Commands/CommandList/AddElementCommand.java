package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.InappropriateArgForCommandException;
import Commands.ExceptionsForCommands.NullException;
import Commands.ExceptionsForCommands.ValueTooBigException;
import Commands.ExceptionsForCommands.ValueTooSmallException;
import Utils.SpaceMarine;

/**
 *One of the commands that extends abstract Command class to
 * implement execute method
 */

public class AddElementCommand extends Command {
    public AddElementCommand(){
        this.name="add";
        this.info="add a new element to collection";
    }

    /**
     * excute command add
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     * @throws ValueTooSmallException
     * @throws ValueTooBigException
     * @throws NullException
     */
    public void execute(CommandHandle commandHandle, String args[]) throws InappropriateArgForCommandException, ValueTooSmallException, ValueTooBigException, NullException {
        if(args.length>1){
            throw new InappropriateArgForCommandException("command add don't accept any parameter.\n");
        }else {
            commandHandle.executeAdd(SpaceMarine.SpaceMarineCreate());
        }
    }
}
