package Utils;

import Commands.ExceptionsForCommands.NullException;
import Commands.ExceptionsForCommands.ValueTooBigException;
import Commands.ExceptionsForCommands.ValueTooSmallException;
import Tools.StringTool;
import Utils.ExceptionsForUtils.InappropriateInputException;
import Utils.ExceptionsForUtils.NotSuchAstartesCategoryException;
import Utils.ExceptionsForUtils.NotSuchWeaponException;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Random;

public class SpaceMarine implements Serializable {
    private  Long id; //Поле не может быть null, Значение поля должно быть больше 0,
    // Значение этого поля должно быть уникальным, Значение этого поля должно
    // генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null,
    // Значение этого поля должно генерироваться автоматически
    private Long health; //Поле не может быть null, Значение поля должно быть больше 0
    private AstartesCategory category; //Поле может быть null
    private Weapon weaponType; //Поле не может быть null
    private MeleeWeapon meleeWeapon; //Поле может быть null
    private Chapter chapter; //Поле может быть null
    private  int position ;
    public static  int positionCode =0;

    public SpaceMarine( String name, Coordinates coordinates,
                       Long health, AstartesCategory category, Weapon weaponType,
                       MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = generateId();
        this.creationDate = ZonedDateTime.now();
        this.position = setPosition();
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public Long getId() {
        return id;
    }

    public static Integer setPosition() {
        positionCode = positionCode + 1;
        return positionCode;
    }

    public Integer getPosition() {
        return position;
    }

    /**
     * generates random Long id
     * @return
     */
    private static Long generateId(){
        Random r = new Random();
        Long randomVal = Math.abs(r.nextLong());
        return randomVal;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getHealth() {
        return health;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void changeId(Long id) {
        this.id = id;
    }

    /**
     * creates a SpaceMarine obj
     * @return
     * @throws NullException
     * @throws ValueTooSmallException
     * @throws ValueTooBigException
     */
    public static SpaceMarine SpaceMarineCreate() throws NullException, ValueTooSmallException, ValueTooBigException {
        System.out.print("Input a number for x which is more than -856 :\n");
        int x;
        Integer y;
        String name, aC, nameChpater;
        AstartesCategory astartesCategory;
        MeleeWeapon meleeWeapon;
        Weapon weapon;
        long count;
        Long hp;
        while (true){
            try{
                String sx = StringTool.Input();
                x=Integer.parseInt(sx);

                if(x<=-856){  throw new ValueTooSmallException("Number should be bigger than - 856");  }
                break;
            }catch (ValueTooSmallException  ex){System.out.println(ex.getMessage());}
            catch (NumberFormatException ex){System.out.println("Please enter something");}
        }
        System.out.print("Input a number for y:\n");

        while (true){
            try {
                String sy=StringTool.Input();
                y=Integer.valueOf(sy);
                break;
            }catch (NumberFormatException ex){System.out.println("Please enter something");}
        }


        System.out.print("name of Space Marine:\n");
        while (true){
            try {
                name=StringTool.Input();
                if(isNumeric(name)){
                    throw new InappropriateInputException("Shouldn't be a number");
                }

                if(name==null||name.equals("")||name.trim().isEmpty()){
                    throw new NullException("Print something\n");
                }
                break;
            }catch (NullException | InappropriateInputException ex){System.out.println(ex.getMessage());
            }
        }

        System.out.print("set Astartes Category \n"+AstartesCategory.List()+":");
        while (true){
            try {
                aC=StringTool.Input();
                aC=aC.toUpperCase();
                astartesCategory = (AstartesCategory) scanEnum(AstartesCategory.class, aC);

                break;
            }catch (NotSuchAstartesCategoryException ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.print("set Melee Weapon \n"+MeleeWeapon.List()+":");
        while (true){
            try {
                String EC=StringTool.Input();
                EC=EC.toUpperCase();
                meleeWeapon = (MeleeWeapon) scanEnum(MeleeWeapon.class, EC);

                break;
            }catch (NotSuchWeaponException ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.print("set  Weapon \n"+Weapon.List()+":");
        while (true){
            try {
                String WC=StringTool.Input();
                WC=WC.toUpperCase();


                if (WC.equals("")){
                        throw new NullPointerException("Can't be empty, try again \n");
                }
                if (!(Weapon.List().contains(WC))){
                        throw new NotSuchWeaponException("no such Weapon Category, try again \n");
                }

                weapon = Weapon.valueOf(WC);
                break;
            }catch (NullException | NotSuchWeaponException | NullPointerException ex){System.out.println(ex.getMessage());}
        }


        System.out.print("set health , should be bigger than 0\n");
        while (true){
            try{
                String health = StringTool.Input();
                hp=Long.parseLong(health);

                if(x<0){  throw new ValueTooSmallException("Number should be bigger than 0\n");  }
                break;
            }catch (ValueTooSmallException  ex){System.out.println(ex.getMessage());}
            catch (NumberFormatException ex){System.out.println("Please enter something\n");}
        }

        System.out.print("set Chapter name\n");
        while (true){
            try {
                nameChpater=StringTool.Input();
                if(isNumeric(name)){
                    throw new InappropriateInputException("Shouldn't be a number");
                }
                if(nameChpater==null||nameChpater.equals("")||nameChpater.trim().isEmpty()){throw new NullException("Print something\n");}
                break;
            }catch (NullException | InappropriateInputException ex){System.out.println(ex.getMessage());}
        }



        System.out.print("set count, should be bigger than 0 and smaller than 1000\n");
        while (true){
            try{
                String mCount=StringTool.Input();
                count=Long.valueOf(mCount);
                if(count<=0){
                    throw new ValueTooSmallException("should bigger than 0\n");
                }
                if(count>1000){
                    throw new ValueTooBigException("should be smaller than 1000\n");
                }
                break;
            }catch (ValueTooSmallException  ex){System.out.println(ex.getMessage());}
            catch (NumberFormatException ex){System.out.println("Please enter something");}
        }


        Coordinates coordinates=new Coordinates(x,y);


        Chapter chapter=new Chapter(nameChpater, count);


        return new SpaceMarine(name, coordinates, hp, astartesCategory, weapon, meleeWeapon, chapter);
    }

    /**
     * scans enum
     * @param enumType
     * @param str
     * @return
     */
    public static Enum<?> scanEnum( Class<? extends Enum> enumType, String str){

        if (str.equals("")||str.trim().isEmpty() ) {return null;}

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

    /**
     * checks if given input is numeric
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

    @Override
    public String toString() {
        return "SpaceMarine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", health=" + health +
                ", category=" + category +
                ", weaponType=" + weaponType +
                ", meleeWeapon=" + meleeWeapon +
                ", chapter=" + chapter +
                '}'+ "\n";
    }


}
