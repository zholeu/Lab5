package Utils;

import java.util.Comparator;

/**
 * Comparator class to compare chapter String value alphabetically
 */
public class CompareChapter implements Comparator<SpaceMarine> {
    /**
     * compares chapter name alphabetically
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(SpaceMarine o1, SpaceMarine o2) {
        int diff=o1.getChapter().getName().charAt(0)-o2.getChapter().getName().charAt(0);
        if(diff>0){
            return 1;
        }else if (diff<0) {
            return -1;
        }
        return 0;
    }
}
