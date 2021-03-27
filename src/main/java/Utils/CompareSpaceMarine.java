package Utils;
import java.util.Comparator;
/**
 * Comparator class to compare SpaceMarine id value
 */
public class CompareSpaceMarine implements Comparator<SpaceMarine> {
    /**
     * compares SpaceMarine id
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(SpaceMarine o1, SpaceMarine o2) {

        if(o1.getId()>o2.getId()){
            return 1;
        }else if (o1.getId()<o2.getId()) {
            return -1;
        }
        return 0;
    }


}
