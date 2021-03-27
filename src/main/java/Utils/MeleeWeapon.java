package Utils;

public enum MeleeWeapon {
    POWER_SWORD,
    MANREAPER,
    LIGHTING_CLAW,
    POWER_BLADE;
    /**
     * to get a list of MeleeWeapon
     * @return
     */
    public static String List() {
        String list="";
        for(MeleeWeapon meleeWeapon:MeleeWeapon.values()){
            list=list+meleeWeapon.name()+"\n";
        }
        return list;
    }

}
