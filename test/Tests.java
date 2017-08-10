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
        PinPad pinPad = new PinPad();
        assertNotNull(pinPad);
    }

    @Test
    public void thePinPadClassShouldHaveAMethodThatReturnsTheSecretNumber(){
        PinPad pinPad = new PinPad();
        assertNotNull(pinPad.returnSecretNumber());
    }

    @Test
    public void thePinPadShouldHaveAnArrayList(){
        PinPad pinPad = new PinPad();
        assertNotNull(pinPad.padNumbers);
    }

    @Test
    public void theArrayListIsOfSizeNine(){
        PinPad pinPad = new PinPad();
        assertEquals(9, pinPad.padNumbers.size());
    }

    @Test
    public void theArrayListContainsTheNumbersZeroThroughNine(){
        PinPad pinPad = new PinPad();
        assertTrue(pinPad.padNumbers.contains(0));
        assertTrue(pinPad.padNumbers.contains(1));
        assertTrue(pinPad.padNumbers.contains(2));
        assertTrue(pinPad.padNumbers.contains(3));
        assertTrue(pinPad.padNumbers.contains(4));
        assertTrue(pinPad.padNumbers.contains(5));
        assertTrue(pinPad.padNumbers.contains(6));
        assertTrue(pinPad.padNumbers.contains(7));
        assertTrue(pinPad.padNumbers.contains(8));
    }

    @Test
    public void thePinPadHasGettersOfKeyNumberAndDirectionNumber(){
        PinPad pinPad = new PinPad();
        assertNotNull(pinPad.getKeyNumber());
        assertNotNull(pinPad.getDirectionNumber());
    }

}
