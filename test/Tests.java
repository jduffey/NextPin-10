import org.junit.Test;

import static org.junit.Assert.*;

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
    public void thePinPadClassShouldHaveAMethodThatReturnsTheSecretNumber() {
        PinPad pinPad = new PinPad();
        assertNotNull(pinPad.returnSecretNumber());
    }

    @Test
    public void thePinPadShouldHaveAnArrayList() {
        PinPad pinPad = new PinPad();
        assertNotNull(pinPad.padNumbers);
    }

    @Test
    public void theArrayListIsOfSizeNine() {
        PinPad pinPad = new PinPad();
        assertEquals(9, pinPad.padNumbers.size());
    }

    @Test
    public void theArrayListContainsTheNumbersZeroThroughNine() {
        PinPad pinPad = new PinPad();
        for (int i = 0; i < 9; i++) {
            assertTrue(pinPad.padNumbers.contains(i));
        }
    }

    @Test
    public void thePinPadHasGettersOfKeyNumberAndDirectionNumber() {
        PinPad pinPad = new PinPad();
        assertNotNull(pinPad.getKeyNumber());
        assertNotNull(pinPad.getDirectionNumber());
    }

    @Test
    public void thePinPadHasSettersForKeyNumberAndDirectionNumber() {
        PinPad pinPad = new PinPad();
        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);
        assertEquals(1, pinPad.getKeyNumber());
        assertEquals(5, pinPad.getDirectionNumber());
    }

    @Test
    public void pinPadShouldHaveAMethodForShufflingTheNumbersInItsArrayList() {
        PinPad pinPad = new PinPad();
        pinPad.shuffle();
        assertTrue(pinPad.padNumbers.indexOf(0) != 0 ||
                pinPad.padNumbers.indexOf(1) != 1 ||
                pinPad.padNumbers.indexOf(2) != 2 ||
                pinPad.padNumbers.indexOf(3) != 3 ||
                pinPad.padNumbers.indexOf(4) != 4 ||
                pinPad.padNumbers.indexOf(5) != 5 ||
                pinPad.padNumbers.indexOf(6) != 6 ||
                pinPad.padNumbers.indexOf(7) != 7 ||
                pinPad.padNumbers.indexOf(8) != 8
        );
    }

    @Test
    public void thePinPadShouldHaveAMethodForSettingTheNumbersForTestingPurposes(){
        PinPad pinPad = new PinPad();
        pinPad.setNumbers(0,1,2,3,4,5,6,7,8);
        for(Integer i = 0; i < 9; i++){
            assertEquals(i, pinPad.padNumbers.get(i));
        }
    }

    @Test
    public void ifTheDirectionNumberIsInTheCenterThenTheSecretNumberIsJustTheKeyNumber(){
        PinPad pinPad = new PinPad();
        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);
        pinPad.setNumbers(0,1,2,3,4,5,6,7,8);
        assertEquals(pinPad.returnSecretNumber(), pinPad.getKeyNumber());
    }

}
