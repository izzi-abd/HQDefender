package DefenceHQ;
import java.util.Random;
/**
 *
 * @author Abdurrahman Izzi
 */
public class Headquarter {
    private Random RD = new Random();
    private int xposition;
    
    boolean stillStand(EnemyRocket ER) {
        if((xposition==ER.getPosition()) && (ER.getState().equals("on target"))){
            return false;
        } else {
            return true;
        }
    }
    
    void setPosition() {
        xposition = RD.nextInt(100);
    }
    
    int getPosition() {
        return xposition;
    }
    
}
