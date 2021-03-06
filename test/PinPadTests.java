import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jedduffey on 8/9/17.
 */
public class PinPadTests {

    private PinPad pinPad;

    @Test
    public void thePinPadClassShouldExist() {
        pinPad = new PinPad(3);
        assertNotNull(pinPad);
    }

    @Test
    public void thePinPadClassShouldHaveAMethodThatReturnsTheSecretNumber() {
        pinPad = new PinPad(3);
        assertNotNull(pinPad.returnSecretNumber());
    }

    @Test
    public void thePinPadShouldHaveAnArrayList() {
        pinPad = new PinPad(3);
        assertNotNull(pinPad.padNumbers);
    }

    @Test
    public void theArrayListIsOfSizeNine() {
        pinPad = new PinPad(3);
        assertEquals(9, pinPad.padNumbers.size());
    }

    @Test
    public void theArrayListContainsTheNumbersZeroThroughNine() {
        pinPad = new PinPad(3);
        for (int i = 0; i < 9; i++) {
            assertTrue(pinPad.padNumbers.contains(i));
        }
    }

    @Test
    public void thePinPadHasSettersAndGettersForKeyNumberAndDirectionNumber() {
        pinPad = new PinPad(3);
        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);
        assertEquals(1, pinPad.getKeyNumber());
        assertEquals(5, pinPad.getDirectionNumber());
    }

    @Test
    public void pinPadShouldHaveAMethodForShufflingTheNumbersInItsArrayList() {
        pinPad = new PinPad(3);
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
        pinPad = new PinPad(3);
        pinPad.setNumbers(0, 1, 2, 3, 4, 5, 6, 7, 8);
        for (Integer i = 0; i < 9; i++) {
            assertEquals(i, pinPad.padNumbers.get(i));
        }
    }

    @Test
    public void ifDirectionNumberIsTopCenterThenSecretNumberIsDirectlyUpOneRowFromKeyNumber() {

        /*This is achieved by moving back three indices from the key number and taking modulo array size.
        Math.floorMod() must be used! Thank you https://stackoverflow.com/questions/5385024/mod-in-java-produces-negative-numbers
        In this test we will examine three cases where the key number is on different rows.
        In all cases the direction number is in the topCenter position.*/

        pinPad = new PinPad(3);
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

        pinPad = new PinPad(3);
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

        pinPad = new PinPad(3);
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

        /*This is achieved by adding one to the index of the key number,
        except in the case of the key number being in the right-hand column where we must subtract two from the index of the key number.
        In all cases the direction number is in the middleRight position.*/

        pinPad = new PinPad(3);
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

        /*This is achieved by subtracting one from the index of the key number,
        except in the case of the key number being in the left-hand column where we must add two from the index of the key number.
        In all cases the direction number is in the middleLeft position.*/

        pinPad = new PinPad(3);
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

    @Test
    public void ifDirectionNumberIsInTopLeftCornerThenSecretNumberCanBeFound() {

        /*This can be achieved by applying the extracted methods for moving the index up and to the left.
        In all cases the direction number is in the topLeft position.*/

        pinPad = new PinPad(3);
        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // The key number is in the top right (so must wrap vertically and one to the left). 
        pinPad.setNumbers(5, 3, 1, 6, 8, 0, 4, 2, 7);
        assertEquals(2, pinPad.returnSecretNumber());

        // The key number is in the center (so must move up one and to the left).
        pinPad.setNumbers(5, 0, 7, 3, 1, 8, 6, 2, 4);
        assertEquals(5, pinPad.returnSecretNumber());

        // The key number is in the bottom left (so must move up one and wrap horizontally).
        pinPad.setNumbers(5, 4, 2, 6, 7, 0, 1, 8, 3);
        assertEquals(0, pinPad.returnSecretNumber());
    }

    @Test
    public void ifDirectionNumberIsInTopRightCornerThenSecretNumberCanBeFound() {

        /*This can be achieved by applying the extracted methods for moving the index up and to the right.
        In all cases the direction number is in the topRight position.*/

        pinPad = new PinPad(3);
        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // The key number is in the top left (so must wrap vertically and one to the right). 
        pinPad.setNumbers(1, 7, 5, 4, 0, 3, 2, 8, 6);
        assertEquals(8, pinPad.returnSecretNumber());

        // The key number is in the center (so must move up one and to the left).
        pinPad.setNumbers(6, 8, 5, 0, 1, 7, 2, 3, 4);
        assertEquals(5, pinPad.returnSecretNumber());

        // The key number is in the bottom right (so must move up one and wrap horizontally).
        pinPad.setNumbers(3, 4, 5, 0, 8, 6, 2, 7, 1);
        assertEquals(0, pinPad.returnSecretNumber());
    }

    @Test
    public void ifDirectionNumberIsInBottomLeftCornerThenSecretNumberCanBeFound() {

        /*This can be achieved by applying the extracted methods for moving the index down and to the left.
        In all cases the direction number is in the bottomLeft position.*/

        pinPad = new PinPad(3);
        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // The key number is in the top left (so must move down one and wrap horizontally). 
        pinPad.setNumbers(1, 6, 7, 4, 0, 3, 5, 2, 8);
        assertEquals(3, pinPad.returnSecretNumber());

        // The key number is in the center (so must move down one and to the left).
        pinPad.setNumbers(4, 3, 6, 7, 1, 8, 5, 2, 0);
        assertEquals(5, pinPad.returnSecretNumber());

        // The key number is in the bottom right (so must wrap vertically and to the right).
        pinPad.setNumbers(4, 2, 7, 3, 8, 6, 5, 0, 1);
        assertEquals(2, pinPad.returnSecretNumber());
    }

    @Test
    public void ifDirectionNumberIsInBottomRightCornerThenSecretNumberCanBeFound() {

        /*This can be achieved by applying the extracted methods for moving the index down and to the right.
        In all cases the direction number is in the bottomRight position.*/

        pinPad = new PinPad(3);
        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // The key number is in the top right (so must move down one and wrap horizontally). 
        pinPad.setNumbers(3, 4, 1, 6, 7, 0, 8, 2, 5);
        assertEquals(6, pinPad.returnSecretNumber());

        // The key number is in the center (so must move down one and to the right).
        pinPad.setNumbers(2, 7, 3, 4, 1, 8, 0, 6, 5);
        assertEquals(5, pinPad.returnSecretNumber());

        // The key number is in the bottom left (so must wrap vertically and to the right).
        pinPad.setNumbers(3, 4, 6, 7, 0, 2, 1, 8, 5);
        assertEquals(4, pinPad.returnSecretNumber());
    }

    @Test
    public void randomizedTestCases() {

        pinPad = new PinPad(3);
        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        pinPad.setNumbers(5, 1, 4, 8, 2, 3, 6, 7, 0);
        assertEquals(6, pinPad.returnSecretNumber());
        pinPad.setNumbers(3, 0, 8, 5, 1, 4, 6, 2, 7);
        assertEquals(5, pinPad.returnSecretNumber());
        pinPad.setNumbers(2, 8, 6, 3, 4, 0, 1, 5, 7);
        assertEquals(2, pinPad.returnSecretNumber());
        pinPad.setNumbers(1, 7, 6, 3, 5, 2, 8, 4, 0);
        assertEquals(1, pinPad.returnSecretNumber());
        pinPad.setNumbers(6, 8, 5, 1, 0, 2, 3, 7, 4);
        assertEquals(8, pinPad.returnSecretNumber());
        pinPad.setNumbers(4, 8, 3, 1, 0, 7, 6, 2, 5);
        assertEquals(2, pinPad.returnSecretNumber());
        pinPad.setNumbers(6, 5, 7, 0, 2, 1, 4, 3, 8);
        assertEquals(7, pinPad.returnSecretNumber());
        pinPad.setNumbers(7, 2, 3, 4, 8, 6, 5, 0, 1);
        assertEquals(2, pinPad.returnSecretNumber());
        pinPad.setNumbers(2, 1, 7, 8, 4, 6, 0, 5, 3);
        assertEquals(4, pinPad.returnSecretNumber());
        pinPad.setNumbers(8, 2, 3, 1, 7, 6, 4, 5, 0);
        assertEquals(4, pinPad.returnSecretNumber());
        pinPad.setNumbers(8, 1, 6, 4, 7, 5, 3, 0, 2);
        assertEquals(6, pinPad.returnSecretNumber());
        pinPad.setNumbers(1, 3, 7, 8, 2, 4, 6, 0, 5);
        assertEquals(2, pinPad.returnSecretNumber());
        pinPad.setNumbers(5, 4, 6, 0, 3, 8, 7, 1, 2);
        assertEquals(0, pinPad.returnSecretNumber());
        pinPad.setNumbers(3, 6, 1, 0, 7, 5, 8, 4, 2);
        assertEquals(3, pinPad.returnSecretNumber());
        pinPad.setNumbers(4, 1, 0, 6, 5, 2, 7, 8, 3);
        assertEquals(1, pinPad.returnSecretNumber());

    }

    @Test
    public void constructorShouldTakeArgumentOfSquareSizeAndGenerateItsArrayBasedOnThatValue() {
        pinPad = new PinPad(3);
        pinPad = new PinPad(3);
        assertEquals(9, pinPad.padNumbers.size());
    }

    @Test
    public void shouldHaveMethodForDeterminingHorizontalDisplacementOfDirectionNumber() {

        pinPad = new PinPad(3);
        pinPad.setNumbers(5, 1, 4, 8, 2, 3, 6, 7, 0);

        pinPad.setDirectionNumber(5);
        assertEquals(-1, pinPad.returnHorizontalDisplacementFactor());
        pinPad.setDirectionNumber(1);
        assertEquals(0, pinPad.returnHorizontalDisplacementFactor());
        pinPad.setDirectionNumber(4);
        assertEquals(1, pinPad.returnHorizontalDisplacementFactor());
        pinPad.setDirectionNumber(8);
        assertEquals(-1, pinPad.returnHorizontalDisplacementFactor());
        pinPad.setDirectionNumber(2);
        assertEquals(0, pinPad.returnHorizontalDisplacementFactor());
        pinPad.setDirectionNumber(3);
        assertEquals(1, pinPad.returnHorizontalDisplacementFactor());
        pinPad.setDirectionNumber(6);
        assertEquals(-1, pinPad.returnHorizontalDisplacementFactor());
        pinPad.setDirectionNumber(7);
        assertEquals(0, pinPad.returnHorizontalDisplacementFactor());
        pinPad.setDirectionNumber(0);
        assertEquals(1, pinPad.returnHorizontalDisplacementFactor());
    }

    @Test
    public void shouldHaveMethodForDeterminingVerticalDisplacementOfDirectionNumber() {

        pinPad = new PinPad(3);
        pinPad.setNumbers(0, 1, 2, 3, 4, 5, 6, 7, 8);

        pinPad.setDirectionNumber(0);
        assertEquals(1, pinPad.returnVerticalDisplacementFactor());
        pinPad.setDirectionNumber(1);
        assertEquals(1, pinPad.returnVerticalDisplacementFactor());
        pinPad.setDirectionNumber(2);
        assertEquals(1, pinPad.returnVerticalDisplacementFactor());
        pinPad.setDirectionNumber(3);
        assertEquals(0, pinPad.returnVerticalDisplacementFactor());
        pinPad.setDirectionNumber(4);
        assertEquals(0, pinPad.returnVerticalDisplacementFactor());
        pinPad.setDirectionNumber(5);
        assertEquals(0, pinPad.returnVerticalDisplacementFactor());
        pinPad.setDirectionNumber(6);
        assertEquals(-1, pinPad.returnVerticalDisplacementFactor());
        pinPad.setDirectionNumber(7);
        assertEquals(-1, pinPad.returnVerticalDisplacementFactor());
        pinPad.setDirectionNumber(8);
        assertEquals(-1, pinPad.returnVerticalDisplacementFactor());
    }

    @Test
    public void testForRefactoringHorizontalMovementCode() {

        pinPad = new PinPad(3);
        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // Direction number in left column.
        pinPad.setNumbers(5, 1, 4, 8, 2, 3, 6, 7, 0);
        assertEquals(6, pinPad.returnSecretNumber());

        // Direction number in middle column.
        pinPad.setNumbers(8, 1, 6, 4, 7, 5, 3, 0, 2);
        assertEquals(6, pinPad.returnSecretNumber());

        // Direction number is in right column.
        pinPad.setNumbers(3, 4, 1, 6, 7, 0, 8, 2, 5);
        assertEquals(6, pinPad.returnSecretNumber());
    }

    @Test
    public void aPinpadOfSquareSizeFourShouldContainTheValuesZeroThroughFifteen() {

        pinPad = new PinPad(4);
        for (int i = 0; i <= 15; i++) {
            assertTrue(pinPad.padNumbers.contains(i));
        }
    }

    @Test
    public void pinpadShouldHaveMethodForSettingValuesWhenSquareSizeIsFourForTestingPurposes() {

        pinPad = new PinPad(4);
        pinPad.setNumbers16(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        for (Integer i = 0; i <= 15; i++) {
            assertEquals(i, pinPad.padNumbers.get(i));
        }
    }

    @Test
    public void returnVerticalAndHorizontalDisplacementMethodsShouldWorkOnOddSizedPads() {

        pinPad = new PinPad(3);
        pinPad.setDirectionNumber(2); // One right of and one above center.
        assertEquals(1, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(1, pinPad.returnVerticalDisplacementFactor());

        pinPad = new PinPad(3);
        pinPad.setDirectionNumber(4); // Dead center.
        assertEquals(0, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(0, pinPad.returnVerticalDisplacementFactor());

        pinPad = new PinPad(3);
        pinPad.setDirectionNumber(6); // One left of and one below center.
        assertEquals(-1, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(-1, pinPad.returnVerticalDisplacementFactor());

        pinPad = new PinPad(5); // ** PAD SIZE FIVE **
        pinPad.setDirectionNumber(4); // Up two, right two.
        assertEquals(2, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(2, pinPad.returnVerticalDisplacementFactor());

        pinPad = new PinPad(5);
        pinPad.setDirectionNumber(8); // Up one, right one.
        assertEquals(1, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(1, pinPad.returnVerticalDisplacementFactor());

        pinPad = new PinPad(5);
        pinPad.setDirectionNumber(12); // Dead center.
        assertEquals(0, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(0, pinPad.returnVerticalDisplacementFactor());

        pinPad = new PinPad(5);
        pinPad.setDirectionNumber(16); // One left, one down.
        assertEquals(-1, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(-1, pinPad.returnVerticalDisplacementFactor());

        pinPad = new PinPad(5);
        pinPad.setDirectionNumber(20); // Two left, two down.
        assertEquals(-2, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(-2, pinPad.returnVerticalDisplacementFactor());

        pinPad = new PinPad(7); // ** PAD SIZE SEVEN **
        pinPad.setDirectionNumber(42); // Three left, three down.
        assertEquals(-3, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(-3, pinPad.returnVerticalDisplacementFactor());
    }

    @Test
    public void returnVerticalAndHorizontalDisplacementMethodsShouldWorkOnEvenSizedPads() {

        pinPad = new PinPad(4);

        pinPad.setDirectionNumber(3); // i.e. top right when pad size is four.
        assertEquals(2, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(2, pinPad.returnVerticalDisplacementFactor());

        pinPad.setDirectionNumber(6); // i.e. top right when pad size is four.
        assertEquals(1, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(1, pinPad.returnVerticalDisplacementFactor());

        pinPad.setDirectionNumber(9); // i.e. top right when pad size is four.
        assertEquals(-1, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(-1, pinPad.returnVerticalDisplacementFactor());

        pinPad.setDirectionNumber(12); // i.e. top right when pad size is four.
        assertEquals(-2, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(-2, pinPad.returnVerticalDisplacementFactor());

        pinPad = new PinPad(8);

        pinPad.setDirectionNumber(7);
        assertEquals(4, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(4, pinPad.returnVerticalDisplacementFactor());

        pinPad.setDirectionNumber(21);
        assertEquals(2, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(2, pinPad.returnVerticalDisplacementFactor());

        pinPad.setDirectionNumber(42);
        assertEquals(-2, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(-2, pinPad.returnVerticalDisplacementFactor());

        pinPad.setDirectionNumber(56);
        assertEquals(-4, pinPad.returnHorizontalDisplacementFactor());
        assertEquals(-4, pinPad.returnVerticalDisplacementFactor());

    }

    /*
    At this point I realized after making a "printer" for random various-sized pads that there appears to be an error
    with the vertical movement in squares larger than size three.

    In squares of size four:
    -When it should go down two it goes down one. (error)
    -When it should go up two it goes up one. (error)
    -When it should go down one it goes down one. (good)
    -When it should go up one it goes up one. (good)

    In squares of size five:
    -When it should go up two it goes up one. (error)
    -When it should go down two it goes down two. (error)

    In squares of size six:
    -When it should go down two it goes down one. (error)
    -When it should go up two it goes up one. (error)
    -When it should go down three it goes down one. (error)
    -When it should go up three it goes up one. (error)

    In squares of size seven:
    -When it should go down one it goes down one. (good)
    -When it should go up one it goes up one. (good)
    -When it should go up two it goes up one. (error)
    -When it should go up three it goes up one. (error)
    -When it should go down three it goes down one. (error)

    Upon investigating squares of size 11 and 12 it appears that the overall bug is that the direction of movement
    in the vertical axis is obeyed but only moves one unit in that direction.

    Therefore we should create tests for various size pads the implement these conditions.
    */

    @Test
    public void verticalDisplacementShouldWorkProperlyForSquareSizeFour() {

        pinPad = new PinPad(4);

        pinPad.setKeyNumber(1);
        pinPad.setDirectionNumber(5);

        // Up two, left one.
        pinPad.setNumbers16(9, 5, 1, 13,
                7, 8, 11, 10,
                4, 12, 14, 6,
                2, 0, 3, 15);
        assertEquals(12, pinPad.returnSecretNumber());

        // Down two, right two.
        pinPad.setNumbers16(9, 0, 1, 13,
                7, 8, 11, 10,
                4, 12, 14, 6,
                2, 15, 3, 5);
        assertEquals(4, pinPad.returnSecretNumber());

    }

}
