package DefenceHQ;

/**
 *
 * @author Abdurrahman Izzi
 */
public class Radar {
    private int Estimate_ERPosition;
    private int Estimate_ERTarget;
    
    void setERPosition(Randomizer RD) {
        Estimate_ERPosition=RD.getERPosition();
    }
    
    void setERTarget(Randomizer RD) {
        Estimate_ERTarget=RD.getERTarget();
    }
    
    int getERPosition() {
        return Estimate_ERPosition;
    }
    
    int getERTarget() {
        return Estimate_ERTarget;
    }
    
}
