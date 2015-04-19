package DefenceHQ;
import java.util.Random;
/**
 *
 * @author Abdurrahman Izzi
 */
public class EnemyRocket {
    private int xposition;
    private int xtarget;
    private String state;
    private Random RD = new Random();
    
    int getTarget() {
        return xtarget;
    }
    
    void setTarget(Randomizer R) {
        xtarget = R.getHQPosition();
    }
    
    void setState(String p_state) {
        state = p_state;
    }
    
    void setPosition(int p_xposition) {
        xposition = p_xposition;
    }
    
    int getPosition() {
        return xposition;
    }
    
    void launch() {
        try{
        setPosition(RD.nextInt(xtarget));
        } catch(IllegalArgumentException e) {
            if(xtarget<0)
            setPosition(RD.nextInt(xtarget*(-1)));
        }
        setState("fly");
    }
    
    String getState() {
        return state;
    }
    
}
