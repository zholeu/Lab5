package Commands;

import Commands.CommandList.*;
import Commands.ExceptionsForCommands.*;
import Tools.StringTool;
import Utils.*;
import java.io.*;
import java.util.*;
import InputOutput.*;
import Utils.ExceptionsForUtils.InappropriateInputException;
import Utils.ExceptionsForUtils.NotSuchAstartesCategoryException;
import Utils.ExceptionsForUtils.NotSuchWeaponException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 *Handles all the commands
 */

public class CommandHandle {

    public CommandHandle(){
        commands.add(new HelpCommand());
        commands.add(new SaveCommand());
        commands.add(new InfoCommand());
        commands.add(new ShowCommand());
        commands.add(new ClearCommand());
        commands.add(new ExitCommand());
        commands.add(new ExecuteScriptCommand());
        commands.add(new ReorderCommand());
        commands.add(new SortCommand());
        commands.add(new RemoveByIdCommand());
        commands.add(new AddElementCommand());
        commands.add(new PrintDescendingCommand());
        commands.add(new PrintFieldDescendingChapterCommand());
        commands.add(new UpdateIdElementCommand());
        commands.add(new InsertAtElementCommand());
        commands.add(new FilterByCategoryCommand());
    }

    Vector<Command> commands = new Vector<>();
    private boolean findid=false;

    public Vector getCommands(){return commands;}

    /**
     * use Iterator to read Vector<Command> commands,and print all helps
     */
    public void executeHelp() {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            Command A = iterator.next();
            System.out.print(A.getName() + ":  " + A.getInfo() + "\n");
        }
    }
    /**
     *saves collection in xml format
     * @throws IOException
     */
    public void executeSave() throws IOException {
        new SpaceMarineUserSetting().doInitialization();
        String env  = System.getenv("IN_PATH");
        if(env==null){
            File fff = new File("ScriptFile/file.xml");
            String fd = fff.getAbsolutePath();
            ParserToXML.writeInXml(new SpaceMarineUserSetting().getSpaceMarines(),fd);
        }
        else {
            File fff = new File(env+"file.xml");
            String fd = fff.getAbsolutePath();
            ParserToXML.writeInXml(new SpaceMarineUserSetting().getSpaceMarines(),fd);
        }

    }
    /**
     *user set and add a new object with the help of static method {@link SpaceMarine#SpaceMarineCreate()}
     * @throws ValueTooBigException
     * @throws ValueTooSmallException
     * @throws NullException
     */
    public void executeAdd(SpaceMarine spaceMarine) throws ValueTooBigException, ValueTooSmallException, NullException {
        new SpaceMarineUserSetting().doInitialization();
        new SpaceMarineUserSetting().getSpaceMarines().add(spaceMarine);
    }
    /**
     *clears the file
     * @throws IOException
     */
    public void executeClear() throws IOException {

        String env = System.getenv("IN_PATH");
        if (env==null){
            File f = new File("ScriptFile/"+"file.xml");
            FileWriter fwOb = new FileWriter(f, false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
            new SpaceMarineUserSetting().getSpaceMarines().clear();
        }else {
            File f = new File(env+"file.xml");
            FileWriter fwOb = new FileWriter(f, false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
            new SpaceMarineUserSetting().getSpaceMarines().clear();
        }

    }
    /**
     *exit from program
     */
    public void executeExit() {
        System.out.print("exit prog");
        System.exit(0);}
    /**
     *print the information of collection(type,amount of elements,when it is created)
     */
    public void executeInfo() {
        if(!SpaceMarineUserSetting.Initialization){
            throw new NotInitializationException("collections was not initialized");
        }else {
            System.out.print("the date of initialization is "+new SpaceMarineUserSetting().getInitializationTime()+"\n");
        }
        System.out.print("the amount of elements is "+ new SpaceMarineUserSetting().getSpaceMarines().size()+"\n");
        System.out.print("the type of collection is "+ new SpaceMarineUserSetting().getSpaceMarines().getClass() +"\n");
    }
    /**
     *show collection
     */
    public void executeShow(){

        if(new SpaceMarineUserSetting().getSpaceMarines().size()==0){
                    System.out.println("collections of space marine still empty\n");
        }
        new StringTool().PrintSpaceMarineSet(new SpaceMarineUserSetting().getSpaceMarines());
    }
    /**
     *removes from the collection by id
     */
    public void executeRemoveById(Long id) {
        SpaceMarine sM=findByid(id);
        if(!findid){
            throw new InappropriateArgForCommandException("no such a person with this id\n");
        }
        findid=false;
        new SpaceMarineUserSetting().getSpaceMarines().remove(sM);
    }
    /**
     *finds element by id
     */
    private SpaceMarine findByid(Long id){
        SpaceMarine p=null;
        SpaceMarine m;
        Iterator<SpaceMarine> iterator=new SpaceMarineUserSetting().getSpaceMarines().iterator();
        out:while(iterator.hasNext()){
            if((m = iterator.next()).getId().equals(id)){
                p=m;
                findid=true;
                break out;
            }
        }
        return p;
    }
    /**
     *reorders the elements upside down
     */
    public void executeReorder(){
        new SpaceMarineUserSetting().doInitialization();
        Collections.reverse(new SpaceMarineUserSetting().getSpaceMarines());
    }
    /**
     *sorts the collection
     */
    public void executeSort(){
        CompareSpaceMarine compareSpaceMarine = new CompareSpaceMarine();
        new SpaceMarineUserSetting().doInitialization();
        new SpaceMarineUserSetting().getSpaceMarines().sort(compareSpaceMarine);
    }
    /**
     *prints the collection descending way
     */
    public void executePrintDescending(){
        CompareSpaceMarine compareSpaceMarine = new CompareSpaceMarine();
        new SpaceMarineUserSetting().doInitialization();
        Collections.sort(new SpaceMarineUserSetting().getSpaceMarines(), Collections.reverseOrder(compareSpaceMarine));
    }
    /**
     *prints chapter value descending
     */
    public void executePrintFieldDescendingChapter(){
        CompareChapter compareChapter = new CompareChapter();
        new SpaceMarineUserSetting().doInitialization();
        Collections.sort(new SpaceMarineUserSetting().getSpaceMarines(), Collections.reverseOrder(compareChapter));
    }
    /**
     *read the Script file line by line using environment variable, if
     * there's no env.var. it uses the argument to execute Script
     * @throws IOException
     * @throws InappropriateArgForCommandException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public void executeScript(String name,CommandHandle commandHandle,int n) throws IOException, InappropriateArgForCommandException, TransformerException, ParserConfigurationException {

            String folder = System.getenv("IN_PATH");
            System.out.println(folder);
        if (n==0){System.out.println("No more recursions");}else {

            if (folder == null) {
                File fv = new File("ScriptFile/" + name);
                String fd = fv.getAbsolutePath();
                FileInputStream f = new FileInputStream(fd);
                System.out.println("  I'll use to find an appropriate file from command argument");
                InputStreamReader isr = new InputStreamReader(f);
                Scanner s = new Scanner(isr).useDelimiter("\\A");
                String result = s.hasNext() ? s.next() : "";
                Scanner scanner = new Scanner(result);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] split = line.split(" ");
                    Command command = findCommand(split[0]);
                    if(command==null){
                        if (split[0].equalsIgnoreCase("clear")){executeClear();}
                        if (split[0].equalsIgnoreCase("add")){addToScript(scanner,command);}
                        if (split[0].equalsIgnoreCase("help")){executeHelp();}
                        if (split[0].equalsIgnoreCase("save")){executeSave();}
                        if (split[0].equalsIgnoreCase("info")){executeInfo();}
                        if (split[0].equalsIgnoreCase("show")){executeShow();}
                        if (split[0].equalsIgnoreCase("exit")){executeExit();}
                        if (split[0].equalsIgnoreCase("reorder")){executeReorder();}
                        if (split[0].equalsIgnoreCase("execute_script")){
                            executeScript(split[1],commandHandle,n);
                        }
                        if (split[0].equalsIgnoreCase("sort")){executeSort();}
                        if (split[0].equalsIgnoreCase("print_descending")){executePrintDescending();}
                        if (split[0].equalsIgnoreCase("print_field_descending_chapter")){executePrintFieldDescendingChapter();}
                    }
                    if (command != null && !(command.getName().equals("add"))&& !(command.getName().equals("execute_script"))) {

                        command.execute(commandHandle, split);
                    }
                    if (command != null && command.getName().equals("execute_script")) {
                        n--;
                        System.out.println(split[1]);
                        executeScript(split[1],commandHandle,n);
                    }
                    if (command != null && command.getName().equalsIgnoreCase("add")){
                        addToScript(scanner, command);
                    }


                }
                scanner.close();
                isr.close();
                s.close();
                f.close();

            } else {

                System.out.println("Environment Variable is successfully used");
                File fff = new File(folder + name);
                String fd = fff.getAbsolutePath();
                FileInputStream f = new FileInputStream(fd);
                InputStreamReader isr = new InputStreamReader(f);
                Scanner s = new Scanner(isr).useDelimiter("\\A");
                String result = s.hasNext() ? s.next() : "";
                Scanner scanner = new Scanner(result);


                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] split = line.split(" ");
                    Command command = findCommand(split[0]);
                    if(command==null){
                        if (split[0].equalsIgnoreCase("clear")){executeClear();}
                        if (split[0].equalsIgnoreCase("add")){addToScript(scanner,command);}
                        if (split[0].equalsIgnoreCase("help")){executeHelp();}
                        if (split[0].equalsIgnoreCase("save")){executeSave();}
                        if (split[0].equalsIgnoreCase("info")){executeInfo();}
                        if (split[0].equalsIgnoreCase("show")){executeShow();}
                        if (split[0].equalsIgnoreCase("exit")){executeExit();}
                        if (split[0].equalsIgnoreCase("reorder")){executeReorder();}
                        if (split[0].equalsIgnoreCase("execute_script")){
                            executeScript(split[1],commandHandle,n);
                        }
                        if (split[0].equalsIgnoreCase("sort")){executeSort();}
                        if (split[0].equalsIgnoreCase("print_descending")){executePrintDescending();}
                        if (split[0].equalsIgnoreCase("print_field_descending_chapter")){executePrintFieldDescendingChapter();}
                    }
                    if (command != null && !(command.getName().equals("add"))&& !(command.getName().equals("execute_script"))) {

                        command.execute(commandHandle, split);
                    }
                    if (command != null && command.getName().equals("execute_script")) {
                        n--;
                        System.out.println(split[1]);
                            executeScript(split[1],commandHandle,n);
                    }
                    if (command != null && command.getName().equalsIgnoreCase("add")){
                        addToScript(scanner, command);
                    }

                }
                scanner.close();
                isr.close();
                s.close();
                f.close();
            }

        }

    }
    /**
     *use Iterator to read Vector<SpaceMarine> ,and updates the element's id values
     */
    public void executeUpdateIdElement(String in){
        Long id=Long.valueOf(in);
        SpaceMarine spaceMarine;
        Iterator<SpaceMarine> iterator=new SpaceMarineUserSetting().getSpaceMarines().iterator();
        while (iterator.hasNext()) {
            if ((spaceMarine = iterator.next()).getId().equals(id)) {
                new SpaceMarineUserSetting().getSpaceMarines().remove(spaceMarine);
                SpaceMarine insert = SpaceMarine.SpaceMarineCreate();
                insert.changeId(id);
                new SpaceMarineUserSetting().getSpaceMarines().add(insert);
                break;
            }
        }
    }

    /**
     * prints the collection's elements that have given category value
     * @param option
     */
    public void executeFilterByCategory(String option){
        new SpaceMarineUserSetting().doInitialization();
        Vector<SpaceMarine> spaceMarinesFl = new Vector<>();

        for (SpaceMarine spaceMarine : new SpaceMarineUserSetting().getSpaceMarines()){
            if (spaceMarine.getCategory().getValue().equals(option)){
                spaceMarinesFl.add(spaceMarine);
                System.out.println(spaceMarine);

            }
        }
        if (spaceMarinesFl.isEmpty()){
            System.out.println("Не найдены продукты с таким владельцем");
        }
    }

    /**
     * use Iterator to read Vector<SpaceMarine> , inserts element by given position
     * @param in
     */
    public void executeInsertAtElement(String in){
        int position=Integer.parseInt(in);
        SpaceMarine spaceMarine;
        Iterator<SpaceMarine> iterator=new SpaceMarineUserSetting().getSpaceMarines().iterator();
        while (iterator.hasNext()) {
            if ((spaceMarine = iterator.next()).getPosition().equals(position)) {
                SpaceMarine insert = SpaceMarine.SpaceMarineCreate();
                int positionFinal = position-1;
                new SpaceMarineUserSetting().getSpaceMarines().add(positionFinal , insert);
                break;
            }
        }
    }

    /**
     * checks if command exist
     * @param name
     * @return
     */
    public Command findCommand(String name){
        Command A=null;
        Command B;
        new SpaceMarineUserSetting().doInitialization();
        Iterator<Command> iterator=commands.iterator();
        while(iterator.hasNext()){
            if((B=iterator.next()).getName().equalsIgnoreCase(name)) {
                A = B;
            }
        }


        return A;
    }

    /**
     * adds to script each element by one
     * @param s
     * @param command
     */
    public void addToScript(Scanner s, Command command){
        String name1, asCat, melWe, wep, chapterName;
        String xx, yy, hpp, countt;
        Integer x;
        Integer y;
        long count;
        Long hp;
        while (s.hasNext()) {
            String line1 = s.nextLine();
            Scanner scR = new Scanner(line1);
            scR.useDelimiter("#");
            xx = scR.next();
            x = Integer.valueOf(xx);
            if(x<=-856){  throw new ValueTooSmallException("While executing file, x number should be bigger than - 856 \n");  }
            yy = scR.next();
            y=Integer.valueOf(yy);
            name1 = scR.next();
            if(isNumeric(name1)){throw new InappropriateInputException("While executing file, name value should not have number \n"); }
            asCat = scR.next();
            melWe = scR.next();
            wep = scR.next();
            if (wep.equals("")){
                throw new NullPointerException("While executing file, сan't be empty, try again \n");
            }
            hpp = scR.next();
            hp=Long.valueOf(hpp);
            if(hp<0){  throw new ValueTooSmallException("While executing file, number should be bigger than 0\n");  }
            chapterName=scR.next();
            if(isNumeric(chapterName)){throw new InappropriateInputException("While executing file, chapter name value should not have number \n"); }
            countt = scR.next();
            count=Long.parseLong(countt);
            if(count<=0){
                throw new ValueTooSmallException("While executing file, count should be bigger than 0\n");
            }
            if(count>1000){
                throw new ValueTooBigException("While executing file, count should be smaller than 1000\n");
            }


            AstartesCategory astartesCategory =(AstartesCategory) scanEnum(AstartesCategory.class, asCat.toUpperCase());
            MeleeWeapon meleeWeapon = (MeleeWeapon) scanEnum(MeleeWeapon.class, melWe);
            Weapon weapon = Weapon.valueOf(wep.toUpperCase());

            Coordinates coordinates = new Coordinates(x, y);
            Chapter chapter = new Chapter(chapterName, count);

            new SpaceMarineUserSetting().doInitialization();
            new SpaceMarineUserSetting().getSpaceMarines().add(new SpaceMarine(name1, coordinates, hp, astartesCategory, weapon, meleeWeapon, chapter));
            if(command!=null){break;}

        }

    }

    /**
     * checks if the input is numeric
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * scans enum
     * @param enumType
     * @param str
     * @return
     */
    public static Enum<?> scanEnum( Class<? extends Enum> enumType, String str){

        if (str.equals("") ) {return null;}
        if(enumType.getTypeName().contains("AstartesCategory")){
            if(!(AstartesCategory.List().contains(str))){
                throw new NotSuchAstartesCategoryException("no such Astartes Category, try again \n");
            }
        }
        if(enumType.getTypeName().contains("MeleeWeapon")){

            if (!(MeleeWeapon.List().contains(str))){
                throw new NotSuchWeaponException("no such Melee Weapon Category, try again \n");

            }
        }
        return Enum.valueOf(enumType, str);

    }









}
