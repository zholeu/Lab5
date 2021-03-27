package Commands;

import Commands.ExceptionsForCommands.InappropriateArgForCommandException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 *Command skeleton
 */
public abstract class Command {

    protected  String name;
    protected  String info;

    public String getName() {
        return name;
    }
    public String getInfo() {
        return info;
    }

    /**
     *Command execution skeleton
     * @param commandHandle
     * @param args
     * @throws InappropriateArgForCommandException
     * @throws IOException
     */
    abstract public void execute(CommandHandle commandHandle, String args[]) throws InappropriateArgForCommandException,
            IOException, TransformerException, ParserConfigurationException;
}
