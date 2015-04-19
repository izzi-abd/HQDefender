package DefenceHQ;
import java.util.Random;
/**
 *
 * @author Abdurrahman Izzi
 */
public class Randomizer {
    int RD_HQPosition;
    int RD_ERPosition;
    int RD_ERTarget;
    Random RD = new Random();
    
    void setHQPosition(Headquarter HQ) {
        RD_HQPosition = HQ.getPosition();
    }
    
    int getHQPosition() {
        int upper= RD_HQPosition+RD.nextInt(100);
        return RD.nextInt(upper);
    }
    
    void setERPosition(EnemyRocket ER) {
        RD_ERPosition = ER.getPosition();
    }
    
    int getERPosition() {
        int upper= RD_ERPosition+RD.nextInt(100);
        return RD.nextInt(upper);
    }
    
    void setERTarget(EnemyRocket ER) {
        RD_ERTarget = ER.getTarget();
    }
    
    int getERTarget() {
        int upper= RD_ERTarget+RD.nextInt(100);
        return RD.nextInt(upper);
    }
}
