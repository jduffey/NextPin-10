import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jedduffey on 8/9/17.
 */
public class Tests {

    private PinPad pinPad;

    @Before
    public void setup() {
        pinPad = new PinPad();
    }

    @Test
    public void thePinPadClassShouldExist() {
        assertNotNull(pinPad);
    }

    @Test
    public void thePinPadClassShouldHaveAMethodThatReturnsTheSecretNumber() {
        assertNotNull(pinPad.returnSecretNumber());
    }

    @Test
    public void thePinPadShouldHaveAnArrayList() {
        assertNotNull(pinPad.padNumbers);
    }

    @Test
    public void theArrayListIsOfSizeNine() {
        assertEquals(9, pinPad.padNumbers.size());
    }

    @Test
    public void theArrayListContainsTheNumbersZeroThroughNine() {
        for (int i = 0; i < 9; i++) {
            assertTrue(pinPad.padNumbers.contains(i));
        }
    }

    @Test
    public void thePinPadHasGettersOfKeyNumberAndDirectionNumber() {
        assertNotNull(pinPad.getKeyNumber());
        assertNotNull(pinPad.getDirectionNumber());
    }

    @Test
    public void thePinPadHasSettersForKeyNumberAndDirectionNumber() {
        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);
        assertEquals(1, pinPad.getKeyNumber());
        assertEquals(5, pinPad.getDirectionNumber());
    }

    @Test
    public void pinPadShouldHaveAMethodForShufflingTheNumbersInItsArrayList() {
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
    public void thePinPadShouldHaveAMethodForSettingTheNumbersForTestingPurposes() {
        pinPad.setNumbers(0, 1, 2, 3, 4, 5, 6, 7, 8);
        for (Integer i = 0; i < 9; i++) {
            assertEquals(i, pinPad.padNumbers.get(i));
        }
    }

    @Test
    public void pinPadShouldHaveMethodsForReturningIndexValuesBasedOnTheNamesOfTheirPositionsInTheArray() {
        pinPad.setNumbers(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(0, pinPad.returnNumber(PinPad.TOP_LEFT_INDEX));
        assertEquals(1, pinPad.returnNumber(PinPad.TOP_CENTER_INDEX));
        assertEquals(2, pinPad.returnNumber(PinPad.TOP_RIGHT_INDEX));
        assertEquals(3, pinPad.returnNumber(PinPad.MIDDLE_LEFT_INDEX));
        assertEquals(4, pinPad.returnNumber(PinPad.MIDDLE_CENTER_INDEX));
        assertEquals(5, pinPad.returnNumber(PinPad.MIDDLE_RIGHT_INDEX));
        assertEquals(6, pinPad.returnNumber(PinPad.BOTTOM_LEFT_INDEX));
        assertEquals(7, pinPad.returnNumber(PinPad.BOTTOM_CENTER_INDEX));
        assertEquals(8, pinPad.returnNumber(PinPad.BOTTOM_RIGHT_INDEX));
    }

}
