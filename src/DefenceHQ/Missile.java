package DefenceHQ;

/**
 *
 * @author Abdurrahman Izzi
 */
public class Missile {
    private int position;
    private String state;
    
    String getState() {
        return state;
    }
    
    int getPosition() {
        return position;
    }
    
    void setState(String p_state) {
        state = p_state;
    }
    
    void intercept(Radar RDR) {
        setState("fly");
        position=RDR.getERPosition();
    }
   
}
