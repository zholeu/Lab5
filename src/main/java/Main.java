import Commands.Command;
import Commands.CommandHandle;
import Commands.ExceptionsForCommands.*;
import InputOutput.ReaderM;
import InputOutput.Writer;
import Tools.StringTool;
import Utils.ExceptionsForUtils.InappropriateInputException;
import Utils.SpaceMarineUserSetting;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {

        new SpaceMarineUserSetting().doInitialization();
        Writer writer = new Writer();
        writer.writerToFile("filetowriteIn.xml");
        ReaderM serv = new ReaderM();
        serv.xmlRead(new SpaceMarineUserSetting().getSpaceMarines(),"filetowriteIn.xml");

        System.out.println("Please print \"help\" command for the navigation.");

        while (true){
            boolean isCommandExist = false;
            CommandHandle commandHandle = new CommandHandle();
            Command command;
            Iterator<Command> iterator = commandHandle.getCommands().iterator();

            System.out.print(">>");
            String[] commandS = StringTool.Input().split(" ");
            try {
                while (iterator.hasNext()) {
                    if ((command = iterator.next()).getName().equalsIgnoreCase(commandS[0])) {
                        command.execute(commandHandle, commandS);
                        isCommandExist=true;
                    }
                }
                if(!isCommandExist){
                    throw new UnknownCommandException("No such command, please enter another one"); }
            }catch (UnknownCommandException | InappropriateArgForCommandException | InappropriateInputException |
                    NullPointerException ex){ System.out.println(ex.getMessage());
            }catch (FileNotFoundException ex){System.out.println("No such file found");
            }catch (ValueTooSmallException ex){System.out.println("While executing script there was an error, because value is too small");
            }catch (NullException ex){System.out.println("While executing script there was an error, out of boundary ");
            }catch (ValueTooBigException ex){System.out.println("While executing script there was an error, because value is too big");
            }catch (NumberFormatException ex){System.out.println("While executing script there was an error ");}

        }
    }
}
