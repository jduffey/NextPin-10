import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jedduffey on 8/9/17.
 */
public class PinPad {

    public static final int PINPAD_SQUARE_SIZE = 3;

    public static final int TOP_LEFT_INDEX = 0;
    public static final int TOP_CENTER_INDEX = 1;
    public static final int TOP_RIGHT_INDEX = 2;
    public static final int MIDDLE_LEFT_INDEX = 3;
    public static final int MIDDLE_CENTER_INDEX = 4;
    public static final int MIDDLE_RIGHT_INDEX = 5;
    public static final int BOTTOM_LEFT_INDEX = 6;
    public static final int BOTTOM_CENTER_INDEX = 7;
    public static final int BOTTOM_RIGHT_INDEX = 8;

    private int keyNumber;
    private int directionNumber;

    ArrayList<Integer> padNumbers;

    public PinPad() {

        padNumbers = new ArrayList<Integer>();

        for (int i = 0; i <
                (PINPAD_SQUARE_SIZE * PINPAD_SQUARE_SIZE); i++) {
            padNumbers.add(i);
        }
    }

    public int returnSecretNumber() {

        int indexOfDirectionNumber = padNumbers.indexOf(getDirectionNumber());
        int indexOfInterimSecretNumber = padNumbers.indexOf(getKeyNumber());

        boolean directionNumberIsInTopRow = indexOfDirectionNumber >= TOP_LEFT_INDEX && indexOfDirectionNumber <= TOP_RIGHT_INDEX;
        boolean directionNumberIsInBottomRow = indexOfDirectionNumber >= BOTTOM_LEFT_INDEX && indexOfDirectionNumber <= BOTTOM_RIGHT_INDEX;
        boolean directionNumberIsInLeftColumn = indexOfDirectionNumber % PINPAD_SQUARE_SIZE == 0;
        boolean directionNumberIsInRightColumn = (indexOfDirectionNumber - 2) % PINPAD_SQUARE_SIZE == 0;

        if (directionNumberIsInTopRow) {
            indexOfInterimSecretNumber = Math.floorMod(indexOfInterimSecretNumber - PINPAD_SQUARE_SIZE, padNumbers.size());
        }
        if (directionNumberIsInBottomRow) {
            indexOfInterimSecretNumber = Math.floorMod(indexOfInterimSecretNumber + PINPAD_SQUARE_SIZE, padNumbers.size());
        }
        if (directionNumberIsInLeftColumn) {
            if (indexOfInterimSecretNumber == TOP_LEFT_INDEX || indexOfInterimSecretNumber == MIDDLE_LEFT_INDEX || indexOfInterimSecretNumber == BOTTOM_LEFT_INDEX) {
                indexOfInterimSecretNumber = indexOfInterimSecretNumber + 2;
            } else indexOfInterimSecretNumber = indexOfInterimSecretNumber - 1;
        }
        if (directionNumberIsInRightColumn) {
            if (indexOfInterimSecretNumber == TOP_RIGHT_INDEX || indexOfInterimSecretNumber == MIDDLE_RIGHT_INDEX || indexOfInterimSecretNumber == BOTTOM_RIGHT_INDEX) {
                indexOfInterimSecretNumber = indexOfInterimSecretNumber - 2;
            } else indexOfInterimSecretNumber = indexOfInterimSecretNumber + 1;
        }

        return padNumbers.get(indexOfInterimSecretNumber);

    }

    public int getKeyNumber() {
        return keyNumber;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }

    public void setKeyNumber(int keyNumber) {
        this.keyNumber = keyNumber;
    }

    public void setDirectionNumber(int directionNumber) {
        this.directionNumber = directionNumber;
    }

    // Created a method for this in case I want to change later how the shuffling/randomizing is implemented.
    public void shuffle() {
        Collections.shuffle(padNumbers);
    }

    public void setNumbers(Integer topLeft, Integer topCenter, Integer topRight, Integer middleLeft, Integer middleCenter, Integer middleRight
            , Integer bottomLeft, Integer bottomCenter, Integer bottomRight) {
        padNumbers.set(0, topLeft);
        padNumbers.set(1, topCenter);
        padNumbers.set(2, topRight);
        padNumbers.set(3, middleLeft);
        padNumbers.set(4, middleCenter);
        padNumbers.set(5, middleRight);
        padNumbers.set(6, bottomLeft);
        padNumbers.set(7, bottomCenter);
        padNumbers.set(8, bottomRight);
    }

    public int returnNumber(int positionOfNumberToReturn) {
        return padNumbers.indexOf(positionOfNumberToReturn);
    }

}
