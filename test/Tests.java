import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jedduffey on 8/9/17.
 */
public class Tests {

    @Test
    public void thePinPadClassShouldExist() {
        PinPad pinPad = new PinPad();
        assertNotNull(pinPad);
    }

    @Test
    public void thePinPadClassShouldHaveAMethodThatReturnsTheSecretNumber(){
        PinPad pinPad = new PinPad();
        assertNotNull(pinPad.returnSecretNumber());
    }

}
