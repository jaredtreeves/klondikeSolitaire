package pile;
import card.*;

/**
 * @author Jared Reeves
 * @version 12-07-2010
 */
public class WastePile extends Pile {
    public boolean canAdd(CardIcon card){
        return true;
    }

    @Override
    public Pile makePile() {
        WastePile wp = new WastePile();
        return wp;
    }

}
