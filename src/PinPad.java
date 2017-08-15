import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jedduffey on 8/9/17.
 */
public class PinPad {

    public static final int PINPAD_SQUARE_SIZE = 3;

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

        boolean directionNumberIsInTopRow = indexOfDirectionNumber >= 0 && indexOfDirectionNumber <= PINPAD_SQUARE_SIZE - 1;
        boolean directionNumberIsInBottomRow = indexOfDirectionNumber >= PINPAD_SQUARE_SIZE * (PINPAD_SQUARE_SIZE - 1) && indexOfDirectionNumber <= padNumbers.size();
        boolean directionNumberIsInLeftColumn = indexOfDirectionNumber % PINPAD_SQUARE_SIZE == 0;
        boolean directionNumberIsInRightColumn = (indexOfDirectionNumber - (PINPAD_SQUARE_SIZE - 1)) % PINPAD_SQUARE_SIZE == 0;

        if (directionNumberIsInTopRow) {
            indexOfInterimSecretNumber = Math.floorMod(indexOfInterimSecretNumber - PINPAD_SQUARE_SIZE, padNumbers.size());
        }
        if (directionNumberIsInBottomRow) {
            indexOfInterimSecretNumber = Math.floorMod(indexOfInterimSecretNumber + PINPAD_SQUARE_SIZE, padNumbers.size());
        }
        if (directionNumberIsInLeftColumn) {
            if (isInterimSecretNumberInLeftColumn(indexOfInterimSecretNumber)) {
                indexOfInterimSecretNumber = indexOfInterimSecretNumber + (PINPAD_SQUARE_SIZE - 1);
            } else indexOfInterimSecretNumber = indexOfInterimSecretNumber - 1;
        }
        if (directionNumberIsInRightColumn) {
            if (isInterimSecretNumberInRightColumn(indexOfInterimSecretNumber)) {
                indexOfInterimSecretNumber = indexOfInterimSecretNumber - (PINPAD_SQUARE_SIZE - 1);
            } else indexOfInterimSecretNumber = indexOfInterimSecretNumber + 1;
        }

        return padNumbers.get(indexOfInterimSecretNumber);

    }

    private boolean isInterimSecretNumberInLeftColumn(int indexOfInterimSecretNumber) {
        return indexOfInterimSecretNumber % PINPAD_SQUARE_SIZE == 0;
    }

    private boolean isInterimSecretNumberInRightColumn(int indexOfInterimSecretNumber) {
        return (indexOfInterimSecretNumber - 2) % PINPAD_SQUARE_SIZE == 0;
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
