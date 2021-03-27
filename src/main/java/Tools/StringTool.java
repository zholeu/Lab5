package Tools;

import Utils.SpaceMarine;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/**
 *Class tool to get input
 */

public class StringTool {

    /**
     * Method that returns string value from
     * input just for the convenience
     * @return
     */
    public static String Input(){
            return new Scanner(System.in).nextLine();
        }

    /**
     *Prints the SpaceMarine collection
     * @param vector
     */
       public void PrintSpaceMarineSet(Vector<SpaceMarine> vector){
           Iterator<SpaceMarine> iterator=vector.iterator();
           while(iterator.hasNext()){
               System.out.print(iterator.next().toString());
           }
       }

}
