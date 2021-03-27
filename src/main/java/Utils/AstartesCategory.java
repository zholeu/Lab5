package Utils;

public enum AstartesCategory {
    SCOUT,
    INCEPTOR,
    TACTICAL,
    TERMINATORMINATOR,
    CHAPLAIN;
public String value;
public String getValue(){return value;}

    /**
     * to get a list of AstartesCategory
     * @return
     */
    public static String List() {
        String list="";
        for(AstartesCategory astartesCategory:AstartesCategory.values()){
            list=list+astartesCategory.name()+"\n";
        }
        return list;
    }



}
