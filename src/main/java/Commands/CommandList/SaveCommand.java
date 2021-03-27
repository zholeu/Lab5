package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.InappropriateArgForCommandException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
/**
 *One of the commands that extends abstract Command class to
 * implement execute method
 */
public class SaveCommand extends Command {
    public SaveCommand(){
        this.name = "save";
        this.info = "saves the collection into a file";
    }

    /**
     * execute command save
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     * @throws IOException
     */
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException, TransformerException, ParserConfigurationException {

        if(args.length>1){
            throw new InappropriateArgForCommandException("This command doesn't have any arguments ");

        }else {commandHandle.executeSave();}
    }
}
