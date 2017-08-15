import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jedduffey on 8/9/17.
 */
public class PinPad {

    private final int squareSize;

    private int keyNumber;
    private int directionNumber;

    ArrayList<Integer> padNumbers;

    public PinPad(int squareSize) {

        this.squareSize = squareSize;

        padNumbers = new ArrayList<Integer>();

        for (int i = 0; i <
                (squareSize * squareSize); i++) {
            padNumbers.add(i);
        }
    }

    public int returnSecretNumber() {

        int indexOfDirectionNumber = padNumbers.indexOf(getDirectionNumber());
        int indexOfInterimSecretNumber = padNumbers.indexOf(getKeyNumber());

        boolean directionNumberIsInTopRow = indexOfDirectionNumber >= 0 && indexOfDirectionNumber <= squareSize - 1;
        boolean directionNumberIsInBottomRow = indexOfDirectionNumber >= squareSize * (squareSize - 1) && indexOfDirectionNumber <= padNumbers.size();
        boolean directionNumberIsInLeftColumn = indexOfDirectionNumber % squareSize == 0;
        boolean directionNumberIsInRightColumn = (indexOfDirectionNumber - (squareSize - 1)) % squareSize == 0;

        if (directionNumberIsInTopRow) {
            indexOfInterimSecretNumber = Math.floorMod(indexOfInterimSecretNumber - squareSize, padNumbers.size());
        }
        if (directionNumberIsInBottomRow) {
            indexOfInterimSecretNumber = Math.floorMod(indexOfInterimSecretNumber + squareSize, padNumbers.size());
        }
        if (directionNumberIsInLeftColumn) {
            if (isInterimSecretNumberInLeftColumn(indexOfInterimSecretNumber)) {
                indexOfInterimSecretNumber = indexOfInterimSecretNumber + (squareSize - 1);
            } else indexOfInterimSecretNumber = indexOfInterimSecretNumber - 1;
        }
        if (directionNumberIsInRightColumn) {
            if (isInterimSecretNumberInRightColumn(indexOfInterimSecretNumber)) {
                indexOfInterimSecretNumber = indexOfInterimSecretNumber - (squareSize - 1);
            } else indexOfInterimSecretNumber = indexOfInterimSecretNumber + 1;
        }

        return padNumbers.get(indexOfInterimSecretNumber);

    }

    private boolean isInterimSecretNumberInLeftColumn(int indexOfInterimSecretNumber) {
        return indexOfInterimSecretNumber % squareSize == 0;
    }

    private boolean isInterimSecretNumberInRightColumn(int indexOfInterimSecretNumber) {
        return (indexOfInterimSecretNumber - 2) % squareSize == 0;
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
