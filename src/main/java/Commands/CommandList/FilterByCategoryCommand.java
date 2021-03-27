package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.InappropriateArgForCommandException;
/**
 *One of the commands that extends abstract Command class to
 * implement execute method
 */
public class FilterByCategoryCommand extends Command {
    public FilterByCategoryCommand(){
        this.name="filter_by_category";
        this.info="filters by existing category";
    }

    /**
     * execute command filter_by_category
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     * @throws NumberFormatException
     */


    public void execute(CommandHandle commandHandle, String [] args) throws InappropriateArgForCommandException,NumberFormatException{
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only and must accept one parameter\n");
        }
           else {
                commandHandle.executeFilterByCategory(String.valueOf(args[1]));
            }

    }
}
