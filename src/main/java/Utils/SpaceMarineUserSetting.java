package Utils;

import Commands.ExceptionsForCommands.InitializationException;
import java.time.ZonedDateTime;
import java.util.Vector;
/**
 *  class deals with the Vector,which save all the people that was set by user.
 */
public class SpaceMarineUserSetting {

        private static ZonedDateTime InitializationTime;
        private static Vector<SpaceMarine> spaceMarines;
        public static boolean Initialization=false;

    /**
     * When static vector SpaceMarine wasn't initialized,throw NotInitializationException
     * @return
     * @throws InitializationException
     */
        public  Vector<SpaceMarine>  getSpaceMarines() throws InitializationException {
            if(!Initialization){
                throw new InitializationException("collections wasn't initialized\n");
            }else {
                return spaceMarines;
            }
        }

    /**
     * does the initialization of SpaceMarine,at the same time,get the current time of initialization
     */

    public void doInitialization(){
            if(!Initialization) {
                spaceMarines = new Vector<>();
                InitializationTime = ZonedDateTime.now();
                Initialization = true;
            }
        }

    /**
     * return InitializationTime
     * @return LocalDate
     */
        public ZonedDateTime getInitializationTime(){
            return InitializationTime;
        }


}
