import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jedduffey on 8/9/17.
 */
public class Tests {

    @Test
    public void thePinPadClassShouldExist() {
        PinPad pinPad = new PinPad(1,5);
        assertNotNull(pinPad);
    }

    @Test
    public void thePinPadClassShouldHaveAMethodThatReturnsTheSecretNumber(){
        PinPad pinPad = new PinPad(1,5);
        assertNotNull(pinPad.returnSecretNumber());
    }

    @Test
    public void thePinPadShouldHaveAnArrayList(){
        PinPad pinPad = new PinPad(1,5);
        assertNotNull(pinPad.padNumbers);
    }

    @Test
    public void theArrayListIsOfSizeNine(){
        PinPad pinPad = new PinPad(1,5);
        assertEquals(9, pinPad.padNumbers.size());
    }

    @Test
    public void theArrayListContainsTheNumbersZeroThroughNine(){
        PinPad pinPad = new PinPad(1,5);
        for (int i = 0; i < 9; i++) {
            assertTrue(pinPad.padNumbers.contains(i));
        }
    }

    @Test
    public void thePinPadHasGettersOfKeyNumberAndDirectionNumber(){
        PinPad pinPad = new PinPad(1,5);
        assertNotNull(pinPad.getKeyNumber());
        assertNotNull(pinPad.getDirectionNumber());
    }

    @Test
    public void thePinPadCanTakeArgumentsForKeyNumberAndDirectionsNumber(){
        PinPad pinPad = new PinPad(1,5);
        assertEquals(1, pinPad.getKeyNumber());
        assertEquals(5, pinPad.getDirectionNumber());
    }

}
