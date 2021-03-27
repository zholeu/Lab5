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

public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand(){
        this.name="execute_script";
        this.info=" read and execute a script from the specified file. The script contains commands in the same form in which the user enters them interactively.";
    }

    /**
     * excute command execute_script
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     * @throws IOException
     */
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException, TransformerException, ParserConfigurationException {

        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only and must accepts one parameter\n");
        }else {
            commandHandle.executeScript(args[1],commandHandle,10);
        }
    }
}
