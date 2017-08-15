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

        fillArrayWithValues(squareSize);
    }

    private void fillArrayWithValues(int squareSize) {
        for (int i = 0; i <
                (squareSize * squareSize); i++) {
            padNumbers.add(i);
        }
    }

    public int returnSecretNumber() {

        int indexOfInterimSecretNumber = moveVertical(padNumbers.indexOf(getKeyNumber()));
        indexOfInterimSecretNumber = moveHorizontal(indexOfInterimSecretNumber);

        return padNumbers.get(indexOfInterimSecretNumber);

    }

    private int moveHorizontal(int indexOfInterimSecretNumber) {

        boolean shouldMoveLeft = returnHorizontalDisplacement() < 0;
        boolean shouldMoveRight = returnHorizontalDisplacement() > 0;

        if (shouldMoveLeft) {
            if (isInterimSecretNumberIsOneLeftOfCenterline(indexOfInterimSecretNumber)) {
                indexOfInterimSecretNumber = indexOfInterimSecretNumber + (squareSize - 1);
            } else indexOfInterimSecretNumber = indexOfInterimSecretNumber - 1;
        }
        if (shouldMoveRight) {
            if (isInterimSecretNumberIsOneRightOfCenterline(indexOfInterimSecretNumber)) {
                indexOfInterimSecretNumber = indexOfInterimSecretNumber - (squareSize - 1);
            } else indexOfInterimSecretNumber = indexOfInterimSecretNumber + 1;
        }
        return indexOfInterimSecretNumber;
    }

    private int moveVertical(int indexOfInterimSecretNumber) {
        if (returnVerticalDisplacement() > 0) {
            indexOfInterimSecretNumber = Math.floorMod(indexOfInterimSecretNumber - squareSize, padNumbers.size());
        } else if (returnVerticalDisplacement() < 0) {
            indexOfInterimSecretNumber = Math.floorMod(indexOfInterimSecretNumber + squareSize, padNumbers.size());
        }
        return indexOfInterimSecretNumber;
    }

    private boolean isInterimSecretNumberIsOneLeftOfCenterline(int indexOfInterimSecretNumber) {
        int verticalCenterlineIndexAsAJavaInt = squareSize / 2;
        return indexOfInterimSecretNumber % squareSize == verticalCenterlineIndexAsAJavaInt - 1;
    }

    private boolean isInterimSecretNumberIsOneRightOfCenterline(int indexOfInterimSecretNumber) {
        int verticalCenterlineIndexAsAJavaInt = squareSize / 2;
        return indexOfInterimSecretNumber % squareSize == verticalCenterlineIndexAsAJavaInt + 1;
    }

    public int returnHorizontalDisplacement() {

        // Like an x-y graph, right is positive and left is negative.
        return padNumbers.indexOf(directionNumber) % squareSize - squareSize / 2;

    }

    public int returnVerticalDisplacement() {

        // Like an x-y graph, up is positive and down is negative.
        return squareSize / 2 - padNumbers.indexOf(directionNumber) / (squareSize);

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
}
