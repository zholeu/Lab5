package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.InappropriateArgForCommandException;

import java.io.IOException;
/**
 *One of the commands that extends abstract Command class to
 * implement execute method
 */
public class RemoveByIdCommand extends Command {
    public RemoveByIdCommand(){
        this.name="remove_by_id";
        this.info="remove one element from the collection by id";
    }


    /**
     * execute command remove_by_id
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     * @throws NumberFormatException
     */
    public void execute(CommandHandle commandHandle,String [] args) throws InappropriateArgForCommandException,NumberFormatException{
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only and must accept one parameter\n");
        }else {
            if(Long.parseLong(args[1])<=0){
                throw new InappropriateArgForCommandException("parameter should bigger than 0\n");
            }else {
                commandHandle.executeRemoveById(Long.valueOf(args[1]));
            }
        }
    }


}
