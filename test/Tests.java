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

    @Test
    public void ifDirectionNumberIsTopCenterThenSecretNumberIsDirectlyUpOneRowFromKeyNumber() {

        /*This is achieved by moving back three indices from the key number and taking modulo array size.
        Math.floorMod() must be used! Thank you https://stackoverflow.com/questions/5385024/mod-in-java-produces-negative-numbers
        In this test we will examine three cases where the key number is on different rows.
        In all cases the direction number is in the topCenter position.*/

        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // The key number is in the top row (top left). 
        pinPad.setNumbers(1, 5, 2, 3, 4, 0, 7, 6, 8);
        assertEquals(7, pinPad.returnSecretNumber());

        // The key number is in the middle row (middle center).
        pinPad.setNumbers(0, 5, 2, 3, 1, 4, 6, 7, 8);
        assertEquals(5, pinPad.returnSecretNumber());

        // The key number is in the bottom row (bottom right).
        pinPad.setNumbers(0, 5, 2, 3, 4, 8, 6, 7, 1);
        assertEquals(8, pinPad.returnSecretNumber());

    }

    @Test
    public void ifDirectionNumberIsBottomCenterThenSecretNumberIsDirectlyDownOneRowFromKeyNumber() {

        /*This is achieved by moving forward three indices from the key number and taking modulo array size.
        In all cases the direction number is in the bottomCenter position.*/

        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // The key number is in the top row (top left). 
        pinPad.setNumbers(1, 6, 3, 2, 4, 8, 0, 5, 7);
        assertEquals(2, pinPad.returnSecretNumber());

        // The key number is in the middle row (middle center).
        pinPad.setNumbers(8, 0, 4, 7, 1, 2, 3, 5, 6);
        assertEquals(5, pinPad.returnSecretNumber());

        // The key number is in the bottom row (bottom right).
        pinPad.setNumbers(0, 2, 6, 4, 7, 8, 3, 5, 1);
        assertEquals(6, pinPad.returnSecretNumber());

    }

    @Test
    public void ifDirectionNumberIsCenterThenSecretNumberIsSameAsKeyNumber() {

        /*This is achieved simply by assigning the value of the key number to the secret number.
        In all cases the direction number is in the middleCenter position.*/

        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // The key number is in the top row (top left). 
        pinPad.setNumbers(1, 7, 8, 4, 5, 0, 2, 3, 6);
        assertEquals(1, pinPad.returnSecretNumber());

        // The key number is in the middle row (middle right).
        pinPad.setNumbers(2, 4, 7, 6, 5, 1, 0, 3, 8);
        assertEquals(1, pinPad.returnSecretNumber());

        // The key number is in the bottom row (bottom left).
        pinPad.setNumbers(2, 6, 8, 3, 5, 4, 1, 7, 0);
        assertEquals(1, pinPad.returnSecretNumber());

    }

    @Test
    public void ifDirectionNumberIsRightCenterThenSecretNumberIsToTheRightOfTheKeyNumber() {

        /*This is achieved by adding one to the index of the key number and taking the modulo of the array size,
        except in the case of the key number being in the right-hand column where we must subtract two from the index of the key number.
        In all cases the direction number is in the middleRight position.*/

        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // The key number is in the left column (top left). 
        pinPad.setNumbers(1, 8, 6, 3, 0, 5, 2, 7, 4);
        assertEquals(8, pinPad.returnSecretNumber());

        // The key number is in the middle column (middle center).
        pinPad.setNumbers(3, 2, 6, 7, 1, 5, 8, 0, 4);
        assertEquals(5, pinPad.returnSecretNumber());

        // The key number is in the right column (bottom right).
        pinPad.setNumbers(0, 3, 8, 4, 7, 5, 6, 2, 1);
        assertEquals(6, pinPad.returnSecretNumber());

    }

    @Test
    public void ifDirectionNumberIsLeftCenterThenSecretNumberIsToTheLeftOfTheKeyNumber() {

        /*This is achieved by subtracting one from the index of the key number and taking the modulo of the array size,
        except in the case of the key number being in the left-hand column where we must add two from the index of the key number.
        In all cases the direction number is in the middleLeft position.*/

        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // The key number is in the left column (top left). 
        pinPad.setNumbers(1, 2, 3, 5, 8, 4, 7, 6, 0);
        assertEquals(3, pinPad.returnSecretNumber());

        // The key number is in the middle column (middle center).
        pinPad.setNumbers(2, 4, 6, 5, 1, 0, 3, 7, 8);
        assertEquals(5, pinPad.returnSecretNumber());

        // The key number is in the right column (bottom right).
        pinPad.setNumbers(2, 6, 0, 5, 0, 3, 8, 4, 1);
        assertEquals(4, pinPad.returnSecretNumber());

    }

}
