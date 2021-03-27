package Utils;

public enum Weapon {
    BOLTGUN,
    COMBI_PLASMA_GUN,
    GRAV_GUN,
    GRENADE_LAUNCHER;
    /**
     * to get a list of Weapon
     * @return
     */
    public static String List() {
        String list="";
        for(Weapon weapon:Weapon.values()){
            list=list+weapon.name()+"\n";
        }
        return list;
    }

}
