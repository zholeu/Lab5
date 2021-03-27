package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.InappropriateArgForCommandException;
/**
 *One of the commands that extends abstract Command class to
 * implement execute method
 */
public class PrintFieldDescendingChapterCommand  extends Command {
    public PrintFieldDescendingChapterCommand(){
        this.name = "print_field_descending_chapter";
        this.info = "prints chapter all elements in descending order";
    }

    /**
     * execute command print_field_descending_chapter
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     */
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException {

        if(args.length>1){
            throw new InappropriateArgForCommandException("This command doesn't have any arguments ");

        }else {commandHandle.executePrintFieldDescendingChapter();}
    }
}
